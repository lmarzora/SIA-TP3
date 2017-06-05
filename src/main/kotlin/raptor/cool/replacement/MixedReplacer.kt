package raptor.cool.replacement

import raptor.cool.characters.Character
import java.util.*

class MixedReplacer(val B: Double, val method1: Replacer, val method2: Replacer) : Replacer {

    override fun replace(characters: List<Character>): List<Character> {
        val size1 = (characters.size*B).toInt()
        if(size1==0) return method2.replace(characters)
        if(size1==characters.size) return method1.replace(characters)
        Collections.shuffle(characters)
        return method1.replace(characters.slice(0..(size1-1))) + method2.replace(characters.slice(size1..characters.size-1))
    }
}