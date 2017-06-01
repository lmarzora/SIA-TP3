package raptor.cool.selection

import raptor.cool.characters.Character
import java.util.*

class RandomDistinctSelector : Selector{
    override fun select(characters: List<Character>, k: Int): List<Character> {
        Collections.shuffle(characters)
        return characters.take(k)
    }
}