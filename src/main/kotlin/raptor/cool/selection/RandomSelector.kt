package raptor.cool.selection

import raptor.cool.characters.Character
import java.util.*

class RandomSelector : Selector{
    override fun select(characters: List<Character>, k: Int): List<Character> {
        val selected = mutableListOf<Character>()
        val rand = Random()
        for (i in 1..k) {
            selected.add(characters[rand.nextInt(characters.size)])
        }

        return selected
    }
}