package raptor.cool.simulation

import config
import gearMap
import raptor.cool.characters.*
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear
import raptor.cool.input.*
import raptor.cool.mutation.Mutator
import raptor.cool.mutation.UniformMutator
import raptor.cool.replacement.*
import raptor.cool.reproduction.*
import raptor.cool.selection.*

class GeneticAlgorithmSimulation : Simulation() {

    var generations = 1
    var population = generatePopulation()

    val mutator = getMutator(config[mutation.method])
    val reproductor = getReproductor(config[reproduction.method])
    val parentSelector = MixedSelector(config[global.a], getSelector(config[selection.parentMethod1]), getSelector(config[selection.parentMethod2]))
    val childrenSelector = MixedSelector(config[global.b], getSelector(config[selection.childrenMethod1]), getSelector(config[selection.childrenMethod2]))
    val replacer = getReplacer(config[replacement.method], config[replacement.k], parentSelector, childrenSelector, mutator, reproductor)

    override fun simulate(): Boolean {
        startSimulation()

        while (!shouldStopSimulation()) {
            population = replacer.replace(population)
            var char = population.sortedBy { it.getFitness() }.last()
            println("h: ${char.height}")
            println("attack: ${char.attack}")
            println("defence: ${char.defence}")
            println("fitness: ${char.getFitness()}")
            println("Char : $char")
            println("----------------------------------------------")
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
        characters.add(getCharacter(config[multi.heir], characterGearMap))
    }
    return characters
}

fun getCharacter(name: String, characterGearMap: MutableMap<String, Gear>): Character {
    val h = (config[mutation.minHeight] + Math.random() * (config[mutation.maxHeight] - config[mutation.minHeight]))
    when(name) {
        "warrior" -> return Warrior(h, characterGearMap)
        "defender" -> return Defender(h, characterGearMap)
        "archer" -> return Archer(h, characterGearMap)
        "assasin" -> return Assasin(h, characterGearMap)
        else -> throw IllegalArgumentException("$name heir not supported")
    }
}

fun getReplacer(name: String, k: Int, parentSelector: Selector, childrenSelector: Selector, mutator: Mutator, reproductor: Reproductor): Replacer {
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
        "deterministic" -> return DeterministicTournament(config[selection.m])
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