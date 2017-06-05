package raptor.cool.selection

import raptor.cool.characters.Character
import java.util.*

class StochasticTournament(val p: Double) : Selector {
    override fun select(characters: List<Character>, k: Int): List<Character> {
        val winners = mutableListOf<Character>()
        for(i in 1..k) {
            val rand = Random()
            val coin = Math.random()

            val participants = mutableListOf<Character>()
            participants.add(characters[rand.nextInt(characters.size)])
            participants.add(characters[rand.nextInt(characters.size)])
            val sortedParticipants = participants.sortedWith(compareBy(Character::getFitness))

            if (coin < p) {
                winners.add(sortedParticipants.first())
            } else {
                winners.add(sortedParticipants.last())
            }
        }
        return winners
    }
}