package characters

import gear.Gear

class Warrior(h: Double, g: MutableMap<String, Gear>): Character(h, g) {
    override fun getFitness(): Double {
        return .6 * attack + .4 * defence
    }


}