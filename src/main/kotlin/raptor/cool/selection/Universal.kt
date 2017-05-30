package raptor.cool.selection

import raptor.cool.characters.Character

class Universal : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        val accumulatedFitness: MutableMap<Double, Character> = mutableMapOf()
        var accum = 0.0
        val totalfitness = characters.sumByDouble(Character::getFitness)
        for (c: Character in characters) {
            accum += c.getFitness()/totalfitness
            accumulatedFitness.put(accum,c)
        }

        val seed = Math.random()
        val rand = (1..k).map { j -> (seed + j - 1) / k }

        val selected = rand.map { r -> accumulatedFitness[accumulatedFitness.keys.firstOrNull { a -> a > r }] }
        return selected.filterNotNull()
    }
}