package characters

import gear.Gear
import java.lang.Math.pow
import java.lang.Math.tanh

abstract class Character(var height: Double, var gear: MutableMap<String, Gear>) {
    val strength = 100*tanh(0.01*gear.values.sumByDouble(Gear::strength))
    val dexterity = tanh(0.01*gear.values.sumByDouble(Gear::dexterity))
    val expertise = 0.6*tanh(0.01*gear.values.sumByDouble(Gear::expertise))
    val resistance = tanh(0.01*gear.values.sumByDouble(Gear::resistance))
    val life = 100*tanh(0.01*gear.values.sumByDouble(Gear::life))
    
    val atm = .5 - pow((3*height-5),4.0) + pow((3*height - 5),2.0) -height/2
    val dem = 2 + pow((3*height-5),4.0) - pow((3*height - 5),2.0) -height/2

    val attack = if((dexterity + expertise) * strength * atm <= 0) (dexterity + expertise) * strength * atm else 0.0
    val defence = if ((resistance + expertise) * life * dem <= 0) (resistance + expertise) * life * dem else 0.0

    abstract fun getFitness(): Double
    override fun toString(): String {
        return "Character(height=$height, gear=$gear, strength=$strength, dexterity=$dexterity, expertise=$expertise, resistance=$resistance, life=$life, atm=$atm, dem=$dem, attack=$attack, defence=$defence)"
    }


}