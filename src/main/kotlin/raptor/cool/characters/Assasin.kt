package characters

import gear.Gear

class Assasin(height: Double, gear: MutableMap<String, Gear>) : Character(height, gear) {
    override fun getFitness(): Double {
        return .7 * attack + .3 * defence
    }
}