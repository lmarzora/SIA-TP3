package raptor.cool.reproduction

import raptor.cool.characters.Character

interface Reproductor {
    fun reproduce(mother: Character, father: Character): Character
}