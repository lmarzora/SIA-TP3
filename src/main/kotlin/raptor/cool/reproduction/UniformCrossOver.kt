package raptor.cool.reproduction

import raptor.cool.characters.Character
import raptor.cool.characters.getGearMap
import raptor.cool.gear.Gear

class UniformCrossOver(var probability: Double = 0.5) : Reproductor {

    override fun reproduce(character1: Character, character2: Character): Character {

        val newGear = mutableListOf<Gear?>()
        val h1 = character1.height
        val h2 = character2.height
        val h = if (Math.random() > probability) h2 else h1
        val chromosome1 = character1.getGearChromosome()
        val chromosome2 = character2.getGearChromosome()
        val L = chromosome1.size

        for (i in (1..L)) newGear.add(if(Math.random() > probability) chromosome2[i] else chromosome1[i])

        return character1.getHeir(h, getGearMap(newGear)) //Asumption: both characters are from the same heir.
    }
}