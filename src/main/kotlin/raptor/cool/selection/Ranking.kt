package raptor.cool.selection

import raptor.cool.characters.Character

class Ranking : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        val competitors = characters.toList()
        val ranking = competitors.sortedWith(compareByDescending(Character::getFitness))
        val accumProbs = mutableMapOf<Double, Character>()
        val probs = (1..characters.size).map{i -> (1.0*i)/ranking.size}

        var accum = 0.0
        for (i in 1..ranking.size-1) {
            accum += probs[i]
            accumProbs.put(accum,competitors[i])
        }
        val rand = (1..k).map { Math.random() }
        val selected = rand.map { r -> accumProbs[accumProbs.keys.firstOrNull { a -> a > r }] }
        return selected.filterNotNull()

    }
}