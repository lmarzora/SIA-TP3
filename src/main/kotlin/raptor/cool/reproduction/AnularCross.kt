package raptor.cool.reproduction

import raptor.cool.characters.Character
import raptor.cool.characters.getGearMap
import raptor.cool.gear.Gear
import java.util.*


class AnularCross() : Reproductor {

    override fun reproduce(mother: Character, father: Character): Character {
        val rnd = Random()
        var locus = rnd.nextInt(7)
        val l = rnd.nextInt(6)
        val newGear = mutableListOf<Gear?>()
        val chromosome1 = mother.getGearChromosome()
        val chromosome2 = father.getGearChromosome()
        for(i in (0..4)) {
            when(i) {
                in locus..(locus+l) -> newGear.add(chromosome2[i])
                else -> newGear.add(chromosome1[i])
            }
        }
        val h = if (locus + l >= 5) mother.height else father.height

        return mother.getHeir(h, getGearMap(newGear)) //Asumption: both characters are from the same heir.
    }
}