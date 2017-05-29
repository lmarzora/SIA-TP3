package raptor.cool.reproduction

import characters.Character
import gear.Gear
import reproduction.Reproductor
import java.util.*

class OnePointCross : Reproductor {

    override fun reproduce(character1: Character, character2: Character): Character {
        val rnd = Random()
        val locus = rnd.nextInt(7)
        val newGear = mutableListOf<Gear?>()
        val chromosome1 = character1.getGearChromosome()
        val chromosome2 = character2.getGearChromosome()
        for(i in (0..4)) {
            when(i) {
                in 0..(locus-1) -> newGear.add(chromosome1[i])
                in locus..4 -> newGear.add(chromosome2[i])
            }
        }
        val h = if(locus!=6) character2.height else character1.height

        return character1.getHeir(h, Character.getGearMap(newGear)) //Asumption: both characters are from the same heir.
    }
}