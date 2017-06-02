package raptor.cool.input

import com.natpryce.konfig.*

object cut : PropertyGroup() {
    val maxgenerations by intType
    val structure by doubleType
    val contentmean by intType
    val contentmax by intType
    val maxfitness by doubleType
}
