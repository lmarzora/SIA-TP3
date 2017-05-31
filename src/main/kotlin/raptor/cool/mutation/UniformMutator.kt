package raptor.cool.mutation

import raptor.cool.characters.Character
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear

class UniformMutator(val availableGenes: Map<String, List<Gear>>,
                     val minHeight: Double,
                     val maxHeight: Double) : Mutator {
    override fun mutate(characters: Collection<Character>, p: Double): Collection<Character> {
        return characters.map { mutateCharacter(it, p) }
    }

    private fun mutateCharacter(character: Character, p: Double): Character {
        var height = character.height
        if (Math.random() < p) {
            height = (minHeight + Math.random() * (maxHeight - minHeight))
        }
        val gear = mutableMapOf<String, Gear>()
        for ((key, value) in gear) {
            if (Math.random() < p) {
                gear.put(key, getRandomGear(key, availableGenes))
            } else
                gear.put(key, value)
        }
        return character.getHeir(height, gear)
    }
}

