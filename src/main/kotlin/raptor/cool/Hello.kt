import raptor.cool.characters.Character
import raptor.cool.characters.Warrior
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear
import raptor.cool.gear.loadGears
import raptor.cool.selection.Roulette

fun main(args: Array<String>) {
	testSelection()
}

fun testSelection() {

    val dataDir = "/home/lumarzo/fulldata/"
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
