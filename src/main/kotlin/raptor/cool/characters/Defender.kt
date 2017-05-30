package raptor.cool.characters

import raptor.cool.gear.Gear

class Defender(height: Double, gear: MutableMap<String, Gear>) : Character(height, gear) {
    override fun getHeir(height: Double, gear: MutableMap<String, Gear>): Character {
        return Defender(height, gear)
    }

    override fun getFitness(): Double {
        return .1 * attack + .9 * defence
    }
}