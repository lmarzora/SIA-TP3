package raptor.cool.selection

import raptor.cool.characters.Character

class Elite : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        return characters.sortedWith(compareBy(Character::getFitness)).subList(0,k)
    }
}