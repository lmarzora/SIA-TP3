package raptor.cool.selection

import characters.Character
import selection.Selector

class Ranking : Selector{
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        val competitors = characters.toList()
        val ranking = competitors.sortedWith(compareByDescending(Character::getFitness))
        val accumProbs = mutableMapOf<Double, Character>()
        val probs = (1..characters.size).map{i -> (1.0*i)/ranking.size}

        var accum = 0.0
        for (i in 1..ranking.size) {
            accum += probs[i]
            accumProbs.put(accum,competitors[i])
        }
        var rand = (1..k).map { Math.random() }

        var selected: List<Character?> = emptyList()
        for (r in rand) {
            selected+= accumProbs[accumProbs.keys.last { a -> r <= a }]
        }
        return selected.filterNotNull()

    }
}