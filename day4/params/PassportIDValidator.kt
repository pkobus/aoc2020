package params

class PassportIDValidator : Validator {

    override fun isValid(value: String): Boolean {
        return value.count() == 9 && value.all { it.isDigit() }
    }

}