package raptor.cool.simulation

import config
import raptor.cool.characters.Character
import raptor.cool.input.*
import raptor.cool.mutation.Mutator
import raptor.cool.mutation.UniformMutator
import raptor.cool.replacement.BatchReplacer
import raptor.cool.replacement.GenerationalReplacer
import raptor.cool.replacement.IterativeReplacer
import raptor.cool.replacement.Replacer
import raptor.cool.reproduction.*
import raptor.cool.selection.*

class GeneticAlgorithmSimulation : Simulation() {

    var generations = 0
    var population = generatePopulation()

    val mutator = getMutator(config[mutation.method])
    val reproductor = getReproductor(config[reproduction.method])
    val selector = if(Math.random() > config[global.b]) getSelector(config[selection.method1]) else getSelector(config[selection.method2])
    val replacer = if(Math.random() > config[global.a]) getReplacer(config[replacement.method1], selector, mutator, reproductor) else getReplacer(config[replacement.method2], selector, mutator, reproductor)

    override fun simulate(): Boolean {
        startSimulation()
        while (!shouldStopSimulation()) {
            population = replacer.replace(population)
            updateObservers()
            population.forEach { it.happyBirthdayToYou() }
            generations++
        }
        finishSimulation()
        return true
    }
}

fun generatePopulation(): List<Character> {
    return emptyList()
}

fun getReplacer(name: String, selector: Selector, mutator: Mutator, reproductor: Reproductor): Replacer {
    val k = config[replacement.k]
    when(name) {
        "batch" -> return BatchReplacer(k, selector, selector, mutator, reproductor)
        "generational" -> return GenerationalReplacer(k, selector, selector, mutator, reproductor)
        "iterative" -> return IterativeReplacer(k, selector, mutator, reproductor)
        else -> throw IllegalArgumentException("$name replacer not supported")
    }
}

//Map missing
fun getMutator(name: String): Mutator {
    when(name) {
        "uniform" -> return UniformMutator(config[mutation.probability], emptyMap(), config[mutation.minHeight], config[mutation.maxHeight])
        else -> throw IllegalArgumentException("$name mutator not supported")
    }
}

fun getReproductor(name: String): Reproductor {
    when(name) {
        "anular" -> return AnularCross(config[reproduction.locus], config[reproduction.l])
        "onepoint" -> return OnePointCross()
        "twopoints" -> return TwoPointsCross()
        "uniform" -> return UniformCrossOver()
        else -> throw IllegalArgumentException("$name reproductor not supported")
    }
}

fun getSelector(name: String): Selector {
    when(name) {
        "boltzmann" -> return BoltzmannSelector(config[selection.temperature])
        "deterministic" -> return DeterministicTournament(config[selection.k])
        "elite" -> return Elite()
        "randomd" -> return RandomDistinctSelector()
        "random" -> return RandomSelector()
        "ranking" -> return Ranking()
        "roulette" -> return Roulette()
        "stochastic" -> return StochasticTournament(config[selection.probability])
        "universal" -> return Universal()
        else -> throw IllegalArgumentException("$name selector not supported")
    }
}