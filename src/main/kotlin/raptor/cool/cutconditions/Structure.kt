package raptor.cool.cutconditions

import raptor.cool.characters.Character
import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation

class Structure(val unchanged:Double) : CutCondition() {

    var prevGeneration: List<Character> = emptyList()

    override fun shouldStop(simulation: Simulation): Boolean {
        val s = simulation as GeneticAlgorithmSimulation
        var matches = 0
        for(character in prevGeneration) {
            if (s.population.contains(character)) {
                matches += 1
            }
        }
        if (unchanged > matches/s.population.size) {
            return true
        }
        prevGeneration = s.population
        return false
    }

}