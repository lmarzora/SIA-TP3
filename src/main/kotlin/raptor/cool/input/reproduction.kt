package raptor.cool.input

import com.natpryce.konfig.PropertyGroup
import com.natpryce.konfig.getValue
import com.natpryce.konfig.stringType

object reproduction : PropertyGroup() {
    val method by stringType
}
