
class NPTRSPassword(val firstNumber: Int, val secondNumber: Int, val character: Char, val password: String) {

    fun isValidForPart1(): Boolean {
        val count = password.count { it.equals(character) }
        return count in firstNumber..secondNumber
    }

    fun isValidForPart2(): Boolean {
        return password[firstNumber-1].equals(character) && !password[secondNumber-1].equals(character) ||
                !password[firstNumber-1].equals(character) && password[secondNumber-1].equals(character)
    }

}