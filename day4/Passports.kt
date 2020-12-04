class Passports {

    private val passports = ArrayList<Passport>()

    fun finishPassport() {
        passports.add(PassportFactory.createPassword())
    }

    fun setLastPassportData(passportLine: String) {
        if (passports.isEmpty()) {
            val passport = PassportFactory.createPassword()
            passport.addLine(passportLine)
            passports.add(passport)
        }
        passports.last().addLine(passportLine)
    }

    fun countPasswordsWithRequiredFieldsFilled(): Int {
        return passports.count { it.requiredFieldsFilled() }
    }

    fun countValidPasswords(): Int {
        return passports.count { it.isValidPassword() }
    }

}