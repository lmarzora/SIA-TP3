import com.natpryce.konfig.ConfigurationProperties
import com.natpryce.konfig.Misconfiguration
import raptor.cool.characters.Character
import raptor.cool.characters.Warrior
import raptor.cool.cutconditions.*
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear
import raptor.cool.gear.loadGears
import raptor.cool.input.cut
import raptor.cool.input.global
import raptor.cool.input.multi
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
var gearMap = mutableMapOf<String, List<Gear>>()

fun main(args: Array<String>) {

    for (i in 0..(args.size - 1)) {
        when {
            args[i].startsWith("-") && (i+1) < args.size && args[i+1].startsWith("-") -> inputParams.put(args[i].substring(1), true)
            args[i].startsWith("-") && (i+1) < args.size -> inputParams.put(args[i].substring(1), args[i+1])
            args[i].startsWith("-") -> inputParams.put(args[i].substring(1), true)
        }
    }

    if (inputParams.containsKey("config")) config = ConfigurationProperties.fromFile(File(inputParams["config"] as String))

    Character.strengthMul = config[multi.strength]
    Character.dexterityMul = config[multi.dexterity]
    Character.expertiseMul = config[multi.expertise]
    Character.resistanceMul = config[multi.resistance]
    Character.lifeMul = config[multi.life]

    val gearFiles = mapOf("weapon" to "armas.tsv", "boot" to "botas.tsv",
            "helmet" to "cascos.tsv", "glove" to "guantes.tsv",
            "armor" to "pecheras.tsv")
    gearMap = mutableMapOf<String, List<Gear>>()
    gearFiles.mapValuesTo(gearMap, { loadGears(config[global.data] + File.separator + it.value) })

    val simulation = GeneticAlgorithmSimulation()

    try { simulation.addObserver(ContentMean(config[cut.contentmean])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(ContentMax(config[cut.contentmax])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(MaxGenerations(config[cut.maxgenerations])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(OptimumCharacter(config[cut.maxfitness])) } catch (e: Misconfiguration) {}
    try { simulation.addObserver(Structure(config[cut.structure])) } catch (e: Misconfiguration) {}

    simulation.simulate()
}