package raptor.cool.selection

import raptor.cool.characters.Character

interface Selector {
    fun select(characters: Collection<Character>, k: Int): Collection<Character>
}