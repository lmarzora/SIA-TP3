package characters

import gear.Gear
import java.lang.Math.pow

abstract class Character(var height: Double, var gear: MutableMap<String, Gear>) {
    val strength = gear.values.sumByDouble(Gear::strength)
    val dexterity = gear.values.sumByDouble(Gear::dexterity)
    val expertise = gear.values.sumByDouble(Gear::expertise)
    val resistance = gear.values.sumByDouble(Gear::resistance)
    val life = gear.values.sumByDouble(Gear::life)
    
    val atm = .5 - pow((3*height-5),4.0) + pow((3*height - 5),2.0) -height/2
    val dem = 2 + pow((3*height-5),4.0) - pow((3*height - 5),2.0) -height/2

    val attack = (dexterity + expertise) * strength * atm
    val defence = (resistance + expertise) * life * dem

    abstract fun getFitness(): Double
}