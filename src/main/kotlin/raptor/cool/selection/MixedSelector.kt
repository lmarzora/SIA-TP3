package raptor.cool.selection

import raptor.cool.characters.Character

class MixedSelector(val A: Double, val method1: Selector, val method2: Selector) : Selector {

    override fun select(characters: List<Character>, k: Int): List<Character> {
        val size1 = (k*A).toInt()
        val size2 = k-size1
        if(size1==0) return method2.select(characters, k)
        if(size2==0) return method1.select(characters, k)
        return method1.select(characters, size1) + method2.select(characters, size2)
    }
}