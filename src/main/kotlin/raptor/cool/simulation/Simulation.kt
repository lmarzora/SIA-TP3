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
        for (observer in observers)
            observer.didStart(this)
    }

    fun updateObservers() {
        for (observer in observers)
            observer.notify(this)
    }

    fun finishSimulation() {
        for (observer in observers)
            observer.didFinish(this)
    }

    fun shouldStopSimulation(): Boolean {
        for (observer in observers) {
            if (observer.shouldStop(this))
                return true
        }
        return false
    }

    abstract fun simulate(): Boolean
}