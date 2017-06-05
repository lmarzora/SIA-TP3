package raptor.cool.mutation

import raptor.cool.characters.Character
import raptor.cool.gear.Gear
import raptor.cool.gear.getRandomGear

class UniformMutator(val p: Double,
                     val availableGenes: Map<String, List<Gear>>,
                     val minHeight: Double,
                     val maxHeight: Double) : Mutator {

    override fun mutate(characters: List<Character>): List<Character> {
        return characters.map { mutateCharacter(it) }
    }

    private fun mutateCharacter(character: Character): Character {
        var height = character.height
        if (Math.random() < p) {
            height = minHeight + Math.random() * (maxHeight - minHeight)
        }
        val gear = mutableMapOf<String, Gear>()
        for ((key, value) in character.gear) {
            if (Math.random() < p) {
                gear.put(key, getRandomGear(key, availableGenes))
            } else {
                gear.put(key, value)
            }
        }
        return character.getHeir(height, gear)
    }
}

