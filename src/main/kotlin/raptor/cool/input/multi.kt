package raptor.cool.input

import com.natpryce.konfig.*

object multi : PropertyGroup() {
    val strength by doubleType
    val dexterity by doubleType
    val expertise by doubleType
    val resistance by doubleType
    val life by doubleType
    val heir by stringType
}
