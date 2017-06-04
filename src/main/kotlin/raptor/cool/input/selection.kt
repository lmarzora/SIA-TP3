package raptor.cool.input

import com.natpryce.konfig.*

object selection : PropertyGroup() {
    val temperature by doubleType
    val k by intType
    val probability by doubleType
    val parentMethod1 by stringType
    val parentMethod2 by stringType
    val childrenMethod1 by stringType
    val childrenMethod2 by stringType
}