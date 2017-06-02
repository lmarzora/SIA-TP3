package raptor.cool.input

import com.natpryce.konfig.PropertyGroup
import com.natpryce.konfig.getValue
import com.natpryce.konfig.stringType

object selection : PropertyGroup() {
    val method1 by stringType
    val method2 by stringType
}