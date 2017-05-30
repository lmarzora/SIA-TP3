package raptor.cool.reproduction

import raptor.cool.characters.Character
import raptor.cool.characters.getGearMap
import raptor.cool.gear.Gear
import java.util.*

class TwoPointsCross : Reproductor {

    override fun reproduce(character1: Character, character2: Character): Character {
        val rnd = Random()
        val r2 = rnd.nextInt(6)
        val r1 = rnd.nextInt(r2+1)
        val newGear = mutableListOf<Gear?>()
        val chromosome1 = character1.getGearChromosome()
        val chromosome2 = character2.getGearChromosome()

        for(i in (0..4)) {
            when(i) {
                in r1..r2 -> newGear.add(chromosome2[i])
                else -> newGear.add(chromosome1[i])
            }
        }
        val h = if(r2 == 5) character2.height else character1.height

        return character1.getHeir(h, getGearMap(newGear)) //Asumption: both characters are from the same heir.
    }
}