package raptor.cool.selection

import characters.Character
import selection.Selector

class Universal : Selector{
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        var accumulatedFitness: MutableMap<Double, Character> = mutableMapOf()
        var accum = 0.0
        var totalfitness = characters.sumByDouble(Character::getFitness)
        for (c: Character in characters) {
            accum += c.getFitness()/totalfitness
            accumulatedFitness.put(accum,c)
        }

        val seed = Math.random()
        var rand = (1..k).map { j -> (seed + j -1) / k}

        var selected = mutableListOf<Character?>()
        for (r in rand) {
            selected.add(accumulatedFitness[accumulatedFitness.keys.last { a -> r <= a }])
        }
        return selected.filterNotNull()
    }
}