package reproduction

import characters.Character

interface Reproductor {
    fun reproduce(character1: Character, character2: Character): Collection<Character>
}