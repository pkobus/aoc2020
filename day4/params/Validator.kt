package params

interface Validator {

    fun isValid(value: String): Boolean

}