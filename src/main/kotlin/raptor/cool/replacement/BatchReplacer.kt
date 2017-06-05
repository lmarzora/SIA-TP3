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
        return mutator.mutate(children).take(K) + generationSelector.select(parents,parents.size - K)
    }
}