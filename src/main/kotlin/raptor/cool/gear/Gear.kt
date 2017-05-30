package raptor.cool.gear

data class Gear(val id: Int,
                val strength: Double,
                val dexterity: Double,
                val expertise: Double,
                val resistance: Double,
                val life: Double)

fun parseGearString(line: String): Gear {
    val stats = line.split(',').map(String::toDouble)
    return Gear(stats[0].toInt(), stats[1], stats[2], stats[3], stats[4], stats[5])
}