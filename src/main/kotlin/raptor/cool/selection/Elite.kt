package raptor.cool.selection

import raptor.cool.characters.Character

class Elite : Selector {
    override fun select(characters: List<Character>, k: Int): List<Character> {
        return characters.sortedWith(compareBy(Character::getFitness)).subList(0,k)
    }
}