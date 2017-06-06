package raptor.cool.observer

import raptor.cool.simulation.GeneticAlgorithmSimulation
import raptor.cool.simulation.Simulation
import raptor.cool.simulation.WriterObserver

class BestCharacterWriter(path: String, interval: Int): WriterObserver(path, interval) {

    override fun writeHeader() {
        printWriter.println("GEN,FITNESS,ATTACK,DEFENSE,HEIGHT")
    }

    override fun write(simulation: Simulation) {
        val s = simulation as GeneticAlgorithmSimulation
        val c = simulation.population.sortedBy { it.getFitness() }.last()
        val sb = StringBuilder()
        sb.append(s.generations).append(",")
        sb.append(c.getFitness()).append(",")
        sb.append(c.attack).append(",")
        sb.append(c.defence).append(",")
        sb.append(c.height)
        printWriter.println(sb.toString())
    }

}