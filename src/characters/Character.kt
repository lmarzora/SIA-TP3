package characters

import gear.Gear
import java.lang.Math.pow

abstract class Character(var height:Double, var gear:MutableMap<String, Gear>) {
    val strength:Double = gear.values.sumByDouble(Gear::strength)
    val dexterity:Double = gear.values.sumByDouble(Gear::dexterity)
    val expertise:Double = gear.values.sumByDouble(Gear::expertise)
    val resistance:Double = gear.values.sumByDouble(Gear::resistance)
    val life:Double = gear.values.sumByDouble(Gear::life)
    val atm:Double = .5 - pow((3*height-5),4.0) + pow((3*height - 5),2.0) -height/2
    val dem:Double = 2 + pow((3*height-5),4.0) - pow((3*height - 5),2.0) -height/2
    val attack = (dexterity + expertise) * strength * atm
    val defence = (resistance + expertise) * life * dem

    abstract fun getFitness(): Double
}