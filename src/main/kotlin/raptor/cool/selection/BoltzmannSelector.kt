package raptor.cool.selection

import raptor.cool.characters.Character

class BoltzmannSelector(var temp: Double) : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        var expVal = characters.map { Math.exp(it.getFitness() / temp) }
        val meanTemp = expVal.sumByDouble { it } / characters.size
        expVal = expVal.map { it / meanTemp }

        val accumulatedExp: MutableMap<Double, Character> = mutableMapOf()
        var accum = 0.0
        val totalExp = expVal.sumByDouble { it }
        var i = 0
        for (c: Character in characters) {
            accum += expVal[i++] / totalExp
            accumulatedExp.put(accum, c)
        }
        val rand = (1..k).map { Math.random() }
        val selected = rand.map { r -> accumulatedExp[accumulatedExp.keys.firstOrNull { a -> a > r }] }
        return selected.filterNotNull()

    }
}