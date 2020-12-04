package params

import java.util.regex.Pattern

class HeightValidator(private val cmMin: Int, private val cmMax: Int, private val inMin: Int, private val inMax: Int) : Validator {

    private val pattern = Pattern.compile("(?<value>\\d+)(?<format>cm|in)")

    override fun isValid(value: String): Boolean {
        val matcher = pattern.matcher(value)
        if (matcher.find()) {
            val format = matcher.group("format")
            val height = matcher.group("value").toInt()
            when (format) {
                "cm" -> return height in cmMin..cmMax
                "in" -> return height in inMin..inMax
            }
        }
        return false
    }

}