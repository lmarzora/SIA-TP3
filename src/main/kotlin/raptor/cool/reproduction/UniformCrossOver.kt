package raptor.cool.reproduction

import characters.Character
import gear.Gear
import reproduction.Reproductor

class UniformCrossOver(val probability: Double = 0.5) : Reproductor {

    override fun reproduce(character1: Character, character2: Character): Collection<Character> {

        var newGear:Map<String, Gear> = mutableMapOf()

        

        throw UnsupportedOperationException("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}