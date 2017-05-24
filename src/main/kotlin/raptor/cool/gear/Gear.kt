package gear

class Gear(val id: Int,
           strength: Double,
           dexterity: Double,
           expertise: Double,
           resistance: Double,
           life: Double) {

    companion object {
        val strengthMul = 0.8
        val dexterityMul = 0.9
        val expertiseMul = 0.9
        val resistanceMul = 1.2
        val lifeMul = 1.1

        fun parseGearFile(line: String): Gear {
            var stats = line.split(',').map(String::toDouble)
            return Gear(stats[0].toInt() ,stats[1],stats[2],stats[3],stats[4],stats[5])
        }
    }

    val strength: Double = strength * strengthMul
    val dexterity: Double = dexterity * dexterityMul
    val expertise: Double = expertise * expertiseMul
    val resistance: Double = resistance * resistanceMul
    val life: Double = life * lifeMul
}