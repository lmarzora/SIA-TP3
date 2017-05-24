import characters.Warrior
import gear.Gear

fun main(args: Array<String>) {

	val plateArmor = Gear(1, 5.0, 5.0, 5.0, 5.0, 50.0)
	val sword = Gear(2, strength = 20.0, dexterity = 1.0, expertise = 1.0, resistance = 1.0, life = 0.0)
	var warrior = Warrior(1.5, mutableMapOf("armor" to plateArmor, "weapon" to sword))

	println("Amazing Fitness of ${warrior.getFitness()}")

}
