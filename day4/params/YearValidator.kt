package params

class YearValidator (private val min:Int, private val max: Int): Validator {

    override fun isValid(value: String): Boolean {
        return value.count() == 4 && value.all { it.isDigit() } && value.toInt() >= min && value.toInt() <= max
    }

}