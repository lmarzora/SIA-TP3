package raptor.cool.reproduction

import raptor.cool.characters.Character
import raptor.cool.characters.getGearMap
import raptor.cool.gear.Gear

class UniformCrossOver(var probability: Double = 0.5) : Reproductor {

    override fun reproduce(mother: Character, father: Character): Character {

        val newGear = mutableListOf<Gear?>()
        val h1 = mother.height
        val h2 = father.height
        val h = if (Math.random() > probability) h2 else h1
        val chromosome1 = mother.getGearChromosome()
        val chromosome2 = father.getGearChromosome()
        val L = chromosome1.size

        for (i in (1..L)) newGear.add(if(Math.random() > probability) chromosome2[i] else chromosome1[i])

        return mother.getHeir(h, getGearMap(newGear)) //Asumption: both characters are from the same heir.
    }
}