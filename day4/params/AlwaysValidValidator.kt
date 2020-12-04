package params

class AlwaysValidValidator : Validator {

    override fun isValid(value: String): Boolean {
        return true
    }

}