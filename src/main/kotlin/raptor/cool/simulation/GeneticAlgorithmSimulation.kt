package raptor.cool.simulation

import raptor.cool.characters.Character

class GeneticAlgorithmSimulation : Simulation() {

    var generations = 0
    var population: List<Character> = emptyList()

    override fun simulate(): Boolean {
        startSimulation()
        while (!shouldStopSimulation()) {
            // LOGIC
            // MORE LOGIC
            // SOMEWHERE AROUND HERE WE SHOULD CALL updateObservers()
            // HAPPY BIRTHDAY!!
            population.forEach { it.happyBirthdayToYou() }
        }
        finishSimulation()
        return true
    }

}