package raptor.cool.selection

import characters.Character
import selection.Selector
import java.util.*

class DeterministicTournament(m: Int) : Selector {
    val m = m
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        var winners = emptyList<Character>()
        for(i in 1..k) {
            val rand = Random()
            var participants = emptyList<Character>()
            for(n in 1..m) participants += characters.toList()[rand.nextInt(characters.size)]
            winners += participants.sortedWith(compareBy(Character::getFitness)).first()
        }
        return winners
    }
}