package raptor.cool.cutconditions

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class MaxGenerations(val maxGenerations: Int) : CutCondition() {

    override fun shouldStop(simulation: Simulation): Boolean {
        val ans = (simulation as GeneticAlgorithmSimulation).generations > maxGenerations
        if(ans) shouldStopWarning()
        return ans
    }

    override fun shouldStopWarning() {
        println("[MaxGenerations Observer]: The generation limit($maxGenerations) has been reached")
    }
}