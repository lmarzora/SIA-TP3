package raptor.cool.selection

import raptor.cool.characters.Character
import java.util.*

class StochasticTournament(val p: Double) : Selector {
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        val winners = mutableListOf<Character>()
        for(i in 1..k) {
            val rand = Random()
            val coin = Math.random()

            val participants = mutableListOf<Character>()
            participants.add(characters.toList()[rand.nextInt(characters.size)])
            participants.add(characters.toList()[rand.nextInt(characters.size)])
            val sortedParticipants = participants.sortedWith(compareBy(Character::getFitness))

            if (coin < p)
                winners.add(sortedParticipants.first())
            else
                winners.add(sortedParticipants.last())

        }
        return winners
    }
}