package raptor.cool.cutconditions

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class ContentMax(val generations: Int) : CutCondition() {

    var current = 0
    var maxFitness = 0.0

    override fun shouldStop(simulation: Simulation): Boolean {
        val s = simulation as GeneticAlgorithmSimulation
        val currentMax = s.population.maxBy { it.getFitness() }!!.getFitness()

        if (currentMax <= maxFitness) {
            current++
        } else {
            current = 0
            maxFitness = currentMax
        }

        return current > generations
      }
}
