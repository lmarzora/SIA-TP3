package selection

import characters.Character

class Roulette : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        var totalFitness = characters.sumByDouble(Character::getFitness)
        
    }
}