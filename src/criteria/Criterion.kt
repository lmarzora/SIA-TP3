package criteria

interface Criterion {
    fun cut(): Boolean
}