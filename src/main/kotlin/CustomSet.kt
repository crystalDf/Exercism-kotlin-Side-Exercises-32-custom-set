class CustomSet(vararg number: Int) {

    private var numberSet = number.toSet()

    fun isEmpty(): Boolean {
        return numberSet.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return numberSet.all { it in other.numberSet }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return numberSet.all { it !in other.numberSet }
    }

    fun contains(other: Int): Boolean {
        return numberSet.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        return CustomSet(*numberSet.intersect(other.numberSet).toIntArray())
    }

    fun add(other: Int) {
        numberSet = numberSet.plus(other)
    }

    override fun equals(other: Any?): Boolean {
        return (other is CustomSet) && (numberSet == other.numberSet)
    }

    operator fun plus(other: CustomSet): CustomSet {
        return CustomSet(*numberSet.plus(other.numberSet).toIntArray())
    }

    operator fun minus(other: CustomSet): CustomSet {
        return CustomSet(*numberSet.minus(other.numberSet).toIntArray())
    }
}
