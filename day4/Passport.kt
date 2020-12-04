import params.ParamFactory
import params.PassportParam
import params.PassportParams
import java.util.regex.Pattern

class Passport(params: List<PassportParam>) {

    private val passportParams = PassportParams(params)

    fun addLine(passportLine: String) {
        val compile = Pattern.compile("(?<key>\\w+):(?<value>\\S+)")
        val matcher = compile.matcher(passportLine)
        while (matcher.find()) {
            passportParams.setValue(matcher.group("key"), matcher.group("value"))
        }
    }

    fun requiredFieldsFilled(): Boolean {
        return passportParams.areAllRequiredParamsFilled()
    }

    fun isValidPassword(): Boolean {
        return passportParams.areAllParamsValid()
    }

}
