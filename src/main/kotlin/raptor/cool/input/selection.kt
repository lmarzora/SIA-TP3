package raptor.cool.input

import com.natpryce.konfig.*

object selection : PropertyGroup() {
    val temperature by doubleType
    val k by intType
    val probability by doubleType
    val method1 by stringType
    val method2 by stringType
}