package replacement

import characters.Character

interface Replacer {
    fun replace(characters: Collection<Character>): Collection<Character>
}