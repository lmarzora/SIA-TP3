package raptor.cool.simulation

abstract class Observer : SimulationObserver {
    override fun shouldStop(simulation: Simulation): Boolean {
        return false
    }

    override fun shouldStopWarning() {
    }
}