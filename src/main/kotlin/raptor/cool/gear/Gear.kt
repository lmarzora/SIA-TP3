package raptor.cool.gear

import java.io.File
import java.util.*

data class Gear(val id: Int,
                val strength: Double,
                val dexterity: Double,
                val expertise: Double,
                val resistance: Double,
                val life: Double)

fun parseGearString(line: String): Gear {
    val stats = line.split('\t').map(String::toDouble)
    return Gear(stats[0].toInt(), stats[1], stats[2], stats[3], stats[4], stats[5])
}

fun loadGears(filepath: String): List<Gear> {
    val gears = mutableListOf<Gear>()
    val scan = Scanner(File(filepath).inputStream())
    var line: String
    scan.useDelimiter("\n")
    scan.nextLine()
    while (scan.hasNext()) {
        line = scan.nextLine()
//      println(line)
        gears.add(parseGearString(line))
    }
    return gears
}

fun getRandomGear(key: String, availableGear: Map<String, List<Gear>>): Gear {
    val rand = Random()
    val values = availableGear[key] ?: throw IllegalArgumentException()
    return values[rand.nextInt(values.size)]
}