package raptor.cool.cutconditions

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class ContentMean(val generations: Int) : CutCondition() {

    var current = 0
    var meanHistory: MutableList<Double> = mutableListOf()

    override fun shouldStop(simulation: Simulation): Boolean {
        val s = simulation as GeneticAlgorithmSimulation
        val mean = s.population.sumByDouble { it.getFitness() } / s.population.size

        var found = false
        for (oldMean in meanHistory) {
            if (oldMean < mean) {
                found = true
                break
            }
        }

        if (found) {
            current = 0
        } else {
            current++
        }

        if (current > generations) {
            return true
        }

        if (meanHistory.size > generations) {
            meanHistory.removeAt(0)
        }
        meanHistory.add(meanHistory.size, mean)
        return false
    }

}