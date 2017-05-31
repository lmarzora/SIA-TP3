package raptor.cool.replacement

import raptor.cool.characters.Character
import raptor.cool.mutation.Mutator
import raptor.cool.reproduction.Reproductor
import raptor.cool.selection.Selector
import java.util.*

class BatchReplacer(val k: Int,
                    val parentSelector: Selector,
                    val generationSelector: Selector,
                    val mutator: Mutator,
                    val reproductor: Reproductor) : Replacer {
    override fun replace(characters: List<Character>): List<Character> {
        val parents = mutableListOf(parentSelector.select(characters, k))
        Collections.shuffle(parents)
        if (k % 2 != 0) {
            val bachelor = parents.last()
        }
        val mothers = parents.slice(0..k / 2 - 1)
        val fathers = parents.slice(k / 2..k - 1)
        val childs = emptyList<Character>()
        return childs
    }
}