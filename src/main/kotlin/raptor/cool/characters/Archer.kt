package characters

import gear.Gear

class Archer(height: Double, gear: MutableMap<String, Gear>) : Character(height, gear) {
    override fun getFitness(): Double {
        return .9 * attack + .1 * defence
    }
}