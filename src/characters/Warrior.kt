package characters

import gear.Gear

class Warrior(height: Double, gear: MutableMap<String, Gear>) : Character(height, gear) {
    override fun getFitness(): Double {
        return .6 * attack + .4 * defence
    }
}