package raptor.cool.reproduction

import characters.Character
import gear.Gear
import reproduction.Reproductor

class UniformCrossOver(val probability: Double = 0.5) : Reproductor {

    override fun reproduce(character1: Character, character2: Character): Collection<Character> {

        var newGear:Map<String, Gear> = mutableMapOf()
        val h1 = character1.height
        val h2 = character2.height
        val h = if (Math.random() > probability) h2 else h1
        val chromosome1 = character1.getGearChromosome()
        val chromosome2 = character2.getGearChromosome()
        val L = chromosome1.size


        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}