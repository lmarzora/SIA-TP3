package raptor.cool.selection

import characters.Character
import selection.Selector
import java.util.*

class StochasticTournament(p: Double) : Selector{
    val p = p
    override fun select(characters: Collection<Character>, k: Int): Collection<Character> {
        var winners = emptyList<Character>()
        for(i in 1..k) {
            val rand = Random()
            val coin = Math.random()

            var participants = emptyList<Character>()
            participants += characters.toList()[rand.nextInt(characters.size)]
            participants += characters.toList()[rand.nextInt(characters.size)]
            participants = participants.sortedWith(compareBy(Character::getFitness))

            if (coin < p)
                winners += participants.first()
            else
                winners += participants.last()

        }
        return winners
    }
}