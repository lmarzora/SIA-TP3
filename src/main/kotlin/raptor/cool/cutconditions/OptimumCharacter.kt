package raptor.cool.cutconditions

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class OptimumCharacter(val maxFitness:Double) : CutCondition() {

    override fun shouldStop(simulation: Simulation): Boolean {
        return (simulation as GeneticAlgorithmSimulation).population.any { it.getFitness() >= maxFitness }
    }
}