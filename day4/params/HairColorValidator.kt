package params

import java.util.regex.Pattern

class HairColorValidator : Validator {

    private val pattern = Pattern.compile("#[0-9a-f]{6}+")

    override fun isValid(value: String): Boolean {
        val matcher = pattern.matcher(value)
        return matcher.matches()
    }

}