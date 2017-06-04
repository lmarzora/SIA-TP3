package raptor.cool.input

import com.natpryce.konfig.PropertyGroup
import com.natpryce.konfig.doubleType
import com.natpryce.konfig.getValue
import com.natpryce.konfig.stringType

object mutation : PropertyGroup() {
    val probability by doubleType
    val minHeight by doubleType
    val maxHeight by doubleType
    val method by stringType
}
