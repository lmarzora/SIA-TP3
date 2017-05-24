package characters

import gear.Gear
import java.lang.Math.pow
import java.lang.Math.tanh

abstract class Character(val height: Double, val gear: MutableMap<String, Gear>) {
    val strength = 100*tanh(0.01*gear.values.sumByDouble(Gear::strength))
    val dexterity = tanh(0.01*gear.values.sumByDouble(Gear::dexterity))
    val expertise = 0.6*tanh(0.01*gear.values.sumByDouble(Gear::expertise))
    val resistance = tanh(0.01*gear.values.sumByDouble(Gear::resistance))
    val life = 100*tanh(0.01*gear.values.sumByDouble(Gear::life))
    
    val atm = .5 - pow((3*height-5),4.0) + pow((3*height - 5),2.0) -height/2
    val dem = 2 + pow((3*height-5),4.0) - pow((3*height - 5),2.0) -height/2

    val attack = (dexterity + expertise) * strength * atm
    val defence = (resistance + expertise) * life * dem

    abstract fun getFitness(): Double
    abstract fun getHeir(height: Double, gear: MutableMap<String, Gear>): Character
}