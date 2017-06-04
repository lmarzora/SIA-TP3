package raptor.cool.simulation

import config
import gearMap
import raptor.cool.characters.Character
import raptor.cool.characters.Warrior
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear
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
    val parentSelector = if(Math.random() > config[global.b]) getSelector(config[selection.parentMethod1]) else getSelector(config[selection.parentMethod2])
    val childrenSelector = if(Math.random() > config[global.b]) getSelector(config[selection.childrenMethod1]) else getSelector(config[selection.childrenMethod2])
    val replacer = if(Math.random() > config[global.a]) getReplacer(config[replacement.method1], parentSelector, childrenSelector, mutator, reproductor) else getReplacer(config[replacement.method2], parentSelector, childrenSelector, mutator, reproductor)

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
    val characters = mutableListOf<Character>()

    for (i in 1..config[global.N]) {
        val characterGearMap = mutableMapOf<String, Gear>()
        for (key in gearMap.keys) {
            characterGearMap.put(key, getRandomGear(key, gearMap))
        }
        characters.add(Warrior((1.5 + Math.random() * .5), characterGearMap))
    }
    return characters
}

fun getReplacer(name: String, parentSelector: Selector, childrenSelector: Selector, mutator: Mutator, reproductor: Reproductor): Replacer {
    val k = config[replacement.k]
    when(name) {
        "batch" -> return BatchReplacer(k, parentSelector, childrenSelector, mutator, reproductor)
        "generational" -> return GenerationalReplacer(k, parentSelector, childrenSelector, mutator, reproductor)
        "iterative" -> return IterativeReplacer(k, parentSelector, mutator, reproductor)
        else -> throw IllegalArgumentException("$name replacer not supported")
    }
}

fun getMutator(name: String): Mutator {
    when(name) {
        "uniform" -> return UniformMutator(config[mutation.probability], gearMap, config[mutation.minHeight], config[mutation.maxHeight])
        else -> throw IllegalArgumentException("$name mutator not supported")
    }
}

fun getReproductor(name: String): Reproductor {
    when(name) {
        "anular" -> return AnularCross()
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
