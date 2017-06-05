package raptor.cool.cutconditions

import raptor.cool.characters.Character
import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class Structure(val changed:Double) : CutCondition() {

    var prevGeneration = emptyList<Character>()

    override fun shouldStop(simulation: Simulation): Boolean {
        val s = simulation as GeneticAlgorithmSimulation
        var matches = 0
        if(prevGeneration.size == 0)
            return false
        prevGeneration.filter { s.population.contains(it) }.forEach { matches ++ }

        if (changed > matches/s.population.size) shouldStopWarning()
        if (changed > matches/s.population.size) return true

        prevGeneration = s.population

        return false
    }

    override fun shouldStopWarning() {
        println("[Structure Observer]: The % of similar characters does not goes above $changed")
    }
}