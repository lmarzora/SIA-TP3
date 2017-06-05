package raptor.cool.replacement

import raptor.cool.characters.Character
import raptor.cool.mutation.Mutator
import raptor.cool.reproduction.Reproductor
import java.nio.channels.Selector
import java.util.*

class GenerationalReplacer(var k: Int,
                           val parentSelector: raptor.cool.selection.Selector,
                           val generationSelector: raptor.cool.selection.Selector,
                           val mutator: Mutator,
                           val reproductor: Reproductor) : Replacer {

    override fun replace(characters: List<Character>): List<Character> {
        var K = if (k % 2 != 0) k+1 else k
        val parents = parentSelector.select(characters, K)

        Collections.shuffle(parents)
        val children = mutableListOf<Character>()
        for (i in 1..2) {
            val mothers = parents.slice(0..((K / 2) - 1))
            val fathers = parents.slice((K / 2)..(K - 1))
            for ((mom, dad) in mothers.zip(fathers)) {
                children.add(reproductor.reproduce(mom, dad))
            }
        }
        return generationSelector.select(mutator.mutate(children) + parents,characters.size)
    }
}