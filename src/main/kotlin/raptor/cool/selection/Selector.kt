package selection

import characters.Character

interface Selector {
    fun select(characters: Collection<Character>, k: Int): Collection<Character>
}