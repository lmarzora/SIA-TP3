import characters.Warrior
import gear.Gear

fun main(args: Array<String>) {

	val plateArmor = Gear(1, 5.0, 5.0, 5.0, 5.0, 50.0)
	val sword = Gear(2, 20.0, 1.0, 1.0, 1.0, 0.0)
	var warrior = Warrior(1.5, mutableMapOf("armor" to plateArmor, "weapon" to sword))

	println("Amazing Fitness of ${warrior.getFitness()}")

}
