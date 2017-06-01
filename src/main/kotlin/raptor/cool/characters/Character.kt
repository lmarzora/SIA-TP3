package raptor.cool.characters

import raptor.cool.gear.Gear
import java.lang.Math.pow
import java.lang.Math.tanh

abstract class Character(val height: Double, val gear: Map<String, Gear>) {
    var age = 0

    val strength = 100 * tanh(0.01 * gear.values.sumByDouble(Gear::strength) * strengthMul)
    val dexterity = tanh(0.01 * gear.values.sumByDouble(Gear::dexterity) * dexterityMul)
    val expertise = 0.6 * tanh(0.01 * gear.values.sumByDouble(Gear::expertise) * expertiseMul)
    val resistance = tanh(0.01 * gear.values.sumByDouble(Gear::resistance) * resistanceMul)
    val life = 100 * tanh(0.01 * gear.values.sumByDouble(Gear::life) * lifeMul)

    val atm = .5 - pow((3 * height - 5), 4.0) + pow((3 * height - 5), 2.0) + height / 2
    val dem = 2 + pow((3*height-5),4.0) - pow((3*height - 5),2.0) -height/2

    val attack = if ((dexterity + expertise) * strength * atm >= 0) (dexterity + expertise) * strength * atm else 0.0
    val defence = if ((resistance + expertise) * life * dem >= 0) (resistance + expertise) * life * dem else 0.0

    abstract fun getFitness(): Double

    override fun toString(): String {
        return "Character(height=$height, gear=$gear, strength=$strength, dexterity=$dexterity, expertise=$expertise, resistance=$resistance, life=$life, atm=$atm, dem=$dem, attack=$attack, defence=$defence)"
    }

    abstract fun getHeir(height: Double, gear: MutableMap<String, Gear>): Character

    fun getGearChromosome(): MutableList<Gear?> {
        val gearChromosome: MutableList<Gear?> = mutableListOf()
        gearChromosome.add(gear["weapon"])
        gearChromosome.add(gear["boot"])
        gearChromosome.add(gear["helmet"])
        gearChromosome.add(gear["glove"])
        gearChromosome.add(gear["armor"])
        return gearChromosome
    }

    fun happyBirthdayToYou() {
        age++
    }
    companion object Settings {
        var strengthMul = 0.8
        var dexterityMul = 0.9
        var expertiseMul = 0.9
        var resistanceMul = 1.2
        var lifeMul = 1.1
    }

}

fun getGearMap(list: MutableList<Gear?>): MutableMap<String, Gear> {
    val mp = mutableMapOf<String, Gear>()
    for (i in (0..(list.size - 1))) {
        val g = list[i]
        if (g != null)
            mp.put(whatGear(i), g)
    }
    return mp
}

private fun whatGear(n: Int): String {
    when (n) {
        0 -> return "weapon"
        1 -> return "boot"
        2 -> return "helmet"
        3 -> return "glove"
        4 -> return "armor"
        else -> throw UnsupportedOperationException("Out Of Bounds.")
    }
}