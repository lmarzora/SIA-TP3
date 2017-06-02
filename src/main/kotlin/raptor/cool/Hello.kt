import com.natpryce.konfig.ConfigurationProperties
import com.natpryce.konfig.Misconfiguration
import raptor.cool.characters.Character
import raptor.cool.characters.Warrior
import raptor.cool.cutconditions.*
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear
import raptor.cool.gear.loadGears
import raptor.cool.input.cut
import raptor.cool.mutation.Mutator
import raptor.cool.replacement.Replacer
import raptor.cool.reproduction.OnePointCross
import raptor.cool.reproduction.Reproductor
import raptor.cool.reproduction.TwoPointsCross
import raptor.cool.reproduction.UniformCrossOver
import raptor.cool.selection.*
import raptor.cool.simulation.GeneticAlgorithmSimulation
import java.io.File

val inputParams: MutableMap<String, Any> = mutableMapOf()
var config = ConfigurationProperties.fromResource("default.properties")

fun main(args: Array<String>) {

    for (i in 0..(args.size - 1)) {
        when {
            args[i].startsWith("-") && (i+1) < args.size && args[i+1].startsWith("-") -> inputParams.put(args[i].substring(1), true)
            args[i].startsWith("-") && (i+1) < args.size -> inputParams.put(args[i].substring(1), args[i+1])
            args[i].startsWith("-") -> inputParams.put(args[i].substring(1), true)
        }
    }

    if (inputParams.containsKey("global")) {
        config = ConfigurationProperties.fromFile(File(inputParams["global"] as String))
    }

    val simulation = GeneticAlgorithmSimulation()

    try { simulation.addObserver(ContentMean(config[cut.contentmean])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(ContentMax(config[cut.contentmax])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(MaxGenerations(config[cut.maxgenerations])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(OptimumCharacter(config[cut.maxfitness])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(Structure(config[cut.structure])) } catch (e: Misconfiguration) {}
}

fun getReproductor(name: String): Reproductor {
    when(name) {
        "anular" -> TODO()
        "onepoint" -> return OnePointCross()
        "twopoints" -> return TwoPointsCross()
        "uniform" -> return UniformCrossOver()
        else -> throw IllegalArgumentException("${name} reproductor not supported")
    }
}

fun getSelector(name: String): Selector {
    when(name) {
        "boltzmann" -> TODO()
        "deterministic" -> TODO()
        "elite" -> return Elite()
        "randomd" -> return RandomDistinctSelector()
        "random" -> return RandomSelector()
        "ranking" -> return Ranking()
        "roulette" -> return Roulette()
        "stochastic" -> TODO()
        "universal" -> return Universal()
        else -> throw IllegalArgumentException("${name} selector not supported")
    }
}

fun getReplacer(name: String): Replacer {
    when(name) {
        "batch" -> TODO()
        "generational" -> TODO()
        "iterative" -> TODO()
        else -> throw IllegalArgumentException("${name} replacer not supported")
    }
}

fun getMutator(name: String): Mutator {
    when(name) {
        "uniform" -> return TODO()
        else -> throw IllegalArgumentException("${name} mutator not supported")
    }
}

/*fun main(args: Array<String>) {
    var gen = generatePopulation()
    var previousGen: List<Character>
    val global = parseConfiguration(args[0])
    var meanFitness = mutableListOf<Double>()
    var gens = 0
    var genLimit = true
    var structure = true
    var content = true
    var found = false

    //loadData(global["DataDir"] as String)
    loadData(args[0])

    while ( genLimit && structure && content && !found ) {
        //replacement logic (A*m1 + (1-A)*m2)
        previousGen = gen
        //gen = replacement(...)
        //meanFitness = list of the last X mean fitness (doubles)


        genLimit = gens++ <= (global["GenLimit"] as Int)
        structure = hasStructureChanged(previousGen, gen, global["StructLimit"] as Double)
        content = getMeanFitness(gen) > (meanFitness.sumByDouble {it} / meanFitness.size)
        found = getBestCharacter(gen).getFitness() >= (global["MaxFitness"] as Double)
        //meanFitness = replace oldest mean fitness with new mean fitness

        gen.forEach { it.happyBirthdayToYou() }
    }
}*/

fun generatePopulation(): List<Character> {
    return emptyList()
}

fun hasStructureChanged(prevGen: List<Character>, gen: List<Character>, limit: Double): Boolean {
    //checks if limit% of the characters are overlapped in both lists
    val matches = (1..prevGen.size).sumBy { if(gen.contains(prevGen[it])) 1 else 0 }
    return limit > (matches/gen.size)
}

fun getMeanFitness(gen: List<Character>): Double {
    return gen.sumByDouble { it.getFitness() } / gen.size
}

fun getBestCharacter(chars: List<Character>): Character {
    return chars.sortedBy { it.getFitness() }.first()
}

fun loadData(dataDir: String) {
    println(dataDir)
    val gearFiles = mapOf("weapon" to "armas.tsv", "boot" to "botas.tsv",
            "helmet" to "cascos.tsv", "glove" to "guantes.tsv",
            "armor" to "pecheras.tsv")
    val gearMap = mutableMapOf<String, List<Gear>>()
    gearFiles.mapValuesTo(gearMap, { loadGears(dataDir + it.value) })

    val characters = mutableListOf<Character>()

	for (i in 1..10) {
        val characterMap = mutableMapOf<String, Gear>()
        for (key in gearMap.keys) {
            characterMap.put(key, getRandomGear(key, gearMap))
        }
        characters.add(Warrior((1.5 + Math.random() * .5), characterMap))
	}

    characters.forEach { println("$it") }

    val rouletteSelector = Roulette()
	rouletteSelector.select(characters, 2).forEach { c -> println(c) }

}
