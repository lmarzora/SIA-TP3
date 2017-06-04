package raptor.cool.input

import com.natpryce.konfig.*

object reproduction : PropertyGroup() {
    val locus by intType
    val l by intType
    val method by stringType
}
