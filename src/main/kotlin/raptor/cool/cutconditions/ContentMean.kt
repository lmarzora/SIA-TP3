package raptor.cool.cutconditions

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class ContentMean(val generations: Int) : CutCondition() {

    var current = 0
    var meanHistory = mutableListOf<Double>()

    override fun shouldStop(simulation: Simulation): Boolean {
        val s = simulation as GeneticAlgorithmSimulation
        val mean = s.population.sumByDouble { it.getFitness() } / s.population.size

        val found = meanHistory.any { it < mean }

        current = if (found) 0 else (current+1)

        if (current > generations) return true
        if (meanHistory.size > generations) meanHistory.removeAt(0)

        meanHistory.add(meanHistory.size, mean)
        return false
    }

}