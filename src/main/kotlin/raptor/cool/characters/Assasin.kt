package raptor.cool.characters

import raptor.cool.gear.Gear

class Assasin(height: Double, gear: MutableMap<String, Gear>) : Character(height, gear) {
    override fun getHeir(height: Double, gear: MutableMap<String, Gear>): Character {
        return Assasin(height, gear)
    }

    override fun getFitness(): Double {
        return .7 * attack + .3 * defence
    }
}