package raptor.cool.replacement

import raptor.cool.characters.Character
import raptor.cool.mutation.Mutator
import raptor.cool.reproduction.Reproductor
import raptor.cool.selection.Selector

class IterativeReplacer(val k: Int,
                        val cupid: Selector,
                        val mutator: Mutator,
                        val reproductor: Reproductor) : Replacer  {
    override fun replace(parents: List<Character>): List<Character> {
        val children = mutableListOf<Character>()
        val N = parents.size
        var pair: List<Character>
        for (i in 1..N) {
            pair = cupid.select(parents,2)
            children.add(reproductor.reproduce(pair.first(),pair.last()))
        }
        return mutator.mutate(children)
    }
}