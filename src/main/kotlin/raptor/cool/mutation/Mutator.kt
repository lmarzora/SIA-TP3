package raptor.cool.mutation

import raptor.cool.characters.Character

interface Mutator {
    fun mutate(characters: Collection<Character>, p: Double): Collection<Character>
}