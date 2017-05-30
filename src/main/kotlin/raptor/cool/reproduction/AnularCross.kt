package raptor.cool.reproduction

import raptor.cool.characters.Character
import raptor.cool.characters.getGearMap
import raptor.cool.gear.Gear


class AnularCross(var locus: Int, var l: Int) : Reproductor {

    override fun reproduce(character1: Character, character2: Character): Character {

        val newGear = mutableListOf<Gear?>()
        val chromosome1 = character1.getGearChromosome()
        val chromosome2 = character2.getGearChromosome()
        for(i in (0..4)) {
            when(i) {
                in locus..(locus+l) -> newGear.add(chromosome2[i])
                else -> newGear.add(chromosome1[i])
            }
        }
        val h = if(locus+l>=5) character1.height else character2.height

        return character1.getHeir(h, getGearMap(newGear)) //Asumption: both characters are from the same heir.
    }
}