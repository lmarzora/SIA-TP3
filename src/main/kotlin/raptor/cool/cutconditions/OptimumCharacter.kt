package raptor.cool.cutconditions

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class OptimumCharacter(val maxFitness:Double) : CutCondition() {

    override fun shouldStop(simulation: Simulation): Boolean {
        val ans =  (simulation as GeneticAlgorithmSimulation).population.any { it.getFitness() >= maxFitness }
        if (ans) shouldStopWarning()
        return ans
    }

    override fun shouldStopWarning() {
        println("[OptimumCharacter Observer]: The best character get to $maxFitness fitness")
    }
}