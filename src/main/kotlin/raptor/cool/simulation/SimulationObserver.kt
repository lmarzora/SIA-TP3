package raptor.cool.simulation

interface SimulationObserver {

    fun didStart(simulation: Simulation)
    fun notify(simulation: Simulation)
    fun didFinish(simulation: Simulation)
    fun shouldStop(simulation: Simulation): Boolean

}