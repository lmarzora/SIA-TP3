package raptor.cool.selection

import raptor.cool.characters.Character
import java.lang.Math.random

class Roulette : Selector {
    override fun select(characters: List<Character>, k: Int): List<Character> {
        val accumulatedFitness: MutableMap<Double, Character> = mutableMapOf()
        var accum = 0.0
        val totalFitness = characters.sumByDouble(Character::getFitness)
        for (c: Character in characters) {
            accum += c.getFitness() / totalFitness
            accumulatedFitness.put(accum,c)
        }

        val rand = (1..k).map { random() }
        val selected = rand.map { r -> accumulatedFitness[accumulatedFitness.keys.firstOrNull { a -> a > r }] }
        return selected.filterNotNull()
    }

}