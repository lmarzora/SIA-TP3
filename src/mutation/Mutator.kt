package mutation

import characters.Character

interface Mutator {
    fun mutate(characters: Collection<Character>): Collection<Character>
}