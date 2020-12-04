package params

object ParamFactory {

    private fun createCountryIDParam() = PassportParam("cid", false, AlwaysValidValidator())

    private fun createPassportIDParam() = PassportParam("pid", true, PassportIDValidator())

    private fun createEyeColorParam() = PassportParam("ecl", true, EyeColorValidator())

    private fun createHairColorParam() = PassportParam("hcl", true, HairColorValidator())

    private fun createHeightParam() = PassportParam("hgt", true, HeightValidator(150, 193, 59, 76))

    private fun createExpirationYearParam() = PassportParam("eyr", true, YearValidator(2020, 2030))

    private fun createIssueYearParam() = PassportParam("iyr", true, YearValidator(2010, 2020))

    private fun createBirthYearParam() = PassportParam("byr", true, YearValidator(1920, 2002))

    fun createParams() = listOf(
            createBirthYearParam(),
            createIssueYearParam(),
            createExpirationYearParam(),
            createHeightParam(),
            createHairColorParam(),
            createEyeColorParam(),
            createPassportIDParam(),
            createCountryIDParam()
    )


}