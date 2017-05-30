package raptor.cool.selection

import raptor.cool.characters.Character
import java.util.*

class DeterministicTournament(val m: Int) : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        val winners = mutableListOf<Character>()
        for(i in 1..k) {
            val rand = Random()
            var participants = emptyList<Character>()
            for(n in 1..m) participants += characters.toList()[rand.nextInt(characters.size)]
            winners.add(participants.sortedWith(compareBy(Character::getFitness)).first())
        }
        return winners
    }
}