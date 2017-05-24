package raptor.cool.selection

import characters.Character
import selection.Selector
import java.lang.Math.random

class Roulette : Selector{
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        var accumulatedFitness: MutableMap<Double, Character> = mutableMapOf()
        var accum = 0.0
        for (c: Character in characters) {
            accum += c.getFitness()
            accumulatedFitness.put(accum,c)
        }

        var rand = (1..k).map { random() }

        var selected: List<Character?> = emptyList()
        for (r in rand) {
            selected+= accumulatedFitness[accumulatedFitness.keys.last { a -> r <= a }]
        }
        return selected.filterNotNull()
    }

}