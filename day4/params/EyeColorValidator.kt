package params

class EyeColorValidator : Validator {

    private val availableColors = arrayOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth")

    override fun isValid(value: String): Boolean {
        return availableColors.contains(value)
    }

}