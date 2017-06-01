package raptor.cool.mutation

import raptor.cool.characters.Character

interface Mutator {
    fun mutate(characters: List<Character>): List<Character>
}