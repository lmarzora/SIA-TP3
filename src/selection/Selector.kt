package selection

import characters.Character

interface Selector {
    fun select(characters: Collection<Character>): Collection<Character>
}