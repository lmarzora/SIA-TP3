package raptor.cool.selection

import raptor.cool.characters.Character

interface Selector {
    fun select(characters: List<Character>, k: Int): List<Character>
}