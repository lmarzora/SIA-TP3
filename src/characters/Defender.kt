package characters

import gear.Gear

class Defender(height: Double, gear: MutableMap<String, Gear>) : Character(height, gear) {
    override fun getFitness(): Double {
        return .1 * attack + .9 * defence
    }
}