import characters.Character
import characters.Warrior
import gear.Gear
import raptor.cool.selection.DeterministicTournament
import raptor.cool.selection.Roulette
import raptor.cool.selection.StochasticTournament
import raptor.cool.selection.Universal
import selection.Elite
import java.util.*

fun main(args: Array<String>) {
	testSelection()
}

fun testSelection() {
	var armor = emptyList<Gear>()
	for (i in 1..10) {
		armor += Gear(i, Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
	}
	var weapons = emptyList<Gear>()
	for (i in 11..20) {
		weapons += Gear(i, Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
	}
	var helms = emptyList<Gear>()
	for (i in 21..30) {
		helms += Gear(i, Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
	}
	var shields = emptyList<Gear>()
	for (i in 31..40) {
		shields += Gear(i, Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
	}
	var boots = emptyList<Gear>()
	for (i in 41..50) {
		boots += Gear(i, Math.random(), Math.random(), Math.random(), Math.random(), Math.random())
	}

	var characters = emptyList<Character>()
	var rand = Random()
	for (i in 1..10) {
		characters += Warrior((1.5 + Math.random()) * .5, mutableMapOf(
				"armor" to armor[rand.nextInt(armor.size)],
				"weapons" to weapons[rand.nextInt(weapons.size)],
				"helms" to helms[rand.nextInt(helms.size)],
				"shields" to shields[rand.nextInt(shields.size)],
				"boots" to boots[rand.nextInt(boots.size)]))
	}

//	characters.forEach { c -> print(c.toString() + " " + c.getFitness() + "\n")}

	var rouletteSelector = Universal()

	rouletteSelector.select(characters, 2).forEach { c -> println(c) }

}
