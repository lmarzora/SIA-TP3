package raptor.cool.simulation

abstract class Simulation {

    val observers: MutableList<SimulationObserver> = mutableListOf()

    fun addObserver(observer: SimulationObserver) {
        observers.add(observer)
    }

    fun removeObserver(observer: SimulationObserver) {
        observers.remove(observer)
    }

    fun startSimulation() {
        for (observer in observers) {
            observer.didStart(this)
        }
    }

    fun updateObservers() {
        for (observer in observers) {
            observer.notify(this)
        }
    }

    fun finishSimulation() {
        for (observer in observers) {
            observer.didFinish(this)
        }
    }

    fun shouldStopSimulation(): Boolean {
        return observers.any { it.shouldStop(this) }
    }

    abstract fun simulate(): Boolean
}