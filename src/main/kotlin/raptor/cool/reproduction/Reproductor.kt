package raptor.cool.reproduction

import raptor.cool.characters.Character

interface Reproductor {
    fun reproduce(character1: Character, character2: Character): Character
}