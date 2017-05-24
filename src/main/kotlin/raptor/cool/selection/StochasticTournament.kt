package raptor.cool.selection

import characters.Character
import selection.Selector
import java.util.*

class StochasticTournament(p: Double) : Selector{
    val p = p
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        var winners = mutableListOf<Character>()
        for(i in 1..k) {
            val rand = Random()
            val coin = Math.random()

            var participants = mutableListOf<Character>()
            participants.add(characters.toList()[rand.nextInt(characters.size)])
            participants.add(characters.toList()[rand.nextInt(characters.size)])
            var sortedParticipants = participants.sortedWith(compareBy(Character::getFitness))

            if (coin < p)
                winners.add(sortedParticipants.first())
            else
                winners.add(sortedParticipants.last())

        }
        return winners
    }
}