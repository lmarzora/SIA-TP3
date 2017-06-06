package raptor.cool.simulation

import java.io.PrintWriter

abstract class WriterObserver(val path: String, val interval: Int) : Observer() {

    val printWriter: PrintWriter = PrintWriter(path, "UTF-8")

    override fun didStart(simulation: Simulation) {
        writeHeader()
        write(simulation)
    }

    override fun notify(simulation: Simulation) {
        val s = simulation as GeneticAlgorithmSimulation
        if (s.generations % interval != 0) return
        write(simulation)
    }

    abstract fun writeHeader()
    abstract fun write(simulation: Simulation)

    override fun didFinish(simulation: Simulation) {
        printWriter.close()
    }

}