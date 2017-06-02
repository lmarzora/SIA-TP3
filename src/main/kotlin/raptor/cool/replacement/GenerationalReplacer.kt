package raptor.cool.replacement

import raptor.cool.characters.Character
import raptor.cool.mutation.Mutator
import raptor.cool.reproduction.Reproductor
import java.nio.channels.Selector
import java.util.*

class GenerationalReplacer(val k: Int,
                           val parentSelector: raptor.cool.selection.Selector,
                           val generationSelector: raptor.cool.selection.Selector,
                           val mutator: Mutator,
                           val reproductor: Reproductor) : Replacer {

    override fun replace(characters: List<Character>): List<Character> {
        val parents = if (k % 2 != 0)  parentSelector.select(characters, k + 1) else parentSelector.select(characters, k)

        Collections.shuffle(parents)
        val children = mutableListOf<Character>()
        for (i in 1..2) {
            val mothers = parents.slice(0..(k / 2) - 1)
            val fathers = parents.slice((k / 2)..k - 1)
            for ((mom, dad) in mothers.zip(fathers))
                children.add(reproductor.reproduce(mom, dad))

        }
        return generationSelector.select(mutator.mutate(children) + parents,parents.size)
    }
}