import raptor.cool.characters.Character
import raptor.cool.characters.Warrior
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear
import raptor.cool.gear.loadGears
import raptor.cool.selection.Roulette

fun main(args: Array<String>) {
    var gen = generatePopulation()
    var previousGen: List<Character>
    val params = parseConfiguration(args[0])
    var meanFitness = mutableListOf<Double>()
    var gens = 0
    var genLimit = true
    var structure = true
    var content = true
    var found = false
    while ( genLimit && structure && content && !found ) {
        //replacement logic (A*m1 + (1-A)*m2)
        previousGen = gen
        //gen = replacement(...)
        //meanFitness = list of the last X mean fitness (doubles)


        genLimit = gens++ <= (params["GenLimit"] as Int)
        structure = hasStructureChanged(previousGen, gen, params["StructLimit"] as Double)
        content = getMeanFitness(gen) > (meanFitness.sumByDouble {it} / meanFitness.size)
        found = getBestCharacter(gen).getFitness() >= (params["MaxFitness"] as Double)
        //meanFitness = replace oldest mean fitness with new mean fitness

        gen.forEach { it.happyBirthdayToYou() }
    }
}

fun generatePopulation(): List<Character> {
    return emptyList()
}

fun parseConfiguration(fileName: String ): Map<String, Any> {
    return emptyMap()   
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

fun testSelection(dataDir: String) {
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
