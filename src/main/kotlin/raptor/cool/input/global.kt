package raptor.cool.input

import com.natpryce.konfig.*

object global : PropertyGroup() {
    val a by doubleType
    val b by doubleType
    val data by stringType
}