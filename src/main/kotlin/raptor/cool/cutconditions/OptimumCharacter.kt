package raptor.cool.cutconditions

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class OptimumCharacter(val maxFitness:Double) : CutCondition() {

    override fun shouldStop(simulation: Simulation): Boolean {
        val s = simulation as GeneticAlgorithmSimulation
        for (character in s.population) {
            if (character.getFitness() >= maxFitness) {
                return true
            }
        }
        return false
    }

}