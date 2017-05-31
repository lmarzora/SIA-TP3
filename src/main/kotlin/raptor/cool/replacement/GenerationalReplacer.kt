package raptor.cool.replacement

import raptor.cool.characters.Character
import raptor.cool.mutation.Mutator
import raptor.cool.reproduction.Reproductor
import java.nio.channels.Selector

class GenerationalReplacer(val k: Int,
                           val parentSelector: Selector,
                           val generationSelector: Selector,
                           val mutator: Mutator,
                           val reproductor: Reproductor) : Replacer {
    override fun replace(characters: List<Character>): List<Character> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}