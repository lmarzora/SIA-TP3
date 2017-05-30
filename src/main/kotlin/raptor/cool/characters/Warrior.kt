package raptor.cool.characters

import raptor.cool.gear.Gear

class Warrior(height: Double, gear: MutableMap<String, Gear>) : Character(height, gear) {
    override fun getHeir(height: Double, gear: MutableMap<String, Gear>): Character {
        return Warrior(height, gear)
    }

    override fun getFitness(): Double {
        return .6 * attack + .4 * defence
    }
}