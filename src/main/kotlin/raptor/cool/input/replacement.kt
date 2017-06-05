package raptor.cool.input

import com.natpryce.konfig.PropertyGroup
import com.natpryce.konfig.getValue
import com.natpryce.konfig.intType
import com.natpryce.konfig.stringType

object replacement : PropertyGroup() {
    val k by intType
    val method by stringType
}
