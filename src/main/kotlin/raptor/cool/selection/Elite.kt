package selection

import characters.Character
import kotlin.comparisons.compareBy

class Elite : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        return characters.sortedWith(compareBy(Character::getFitness)).subList(0,k-1)
    }
}