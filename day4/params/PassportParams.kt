package params

class PassportParams(private val params: List<PassportParam>) {

    fun setValue(key: String, value: String) {
        params.filter { it.name == key }.forEach { it.setValue(value) }
    }

    fun areAllRequiredParamsFilled(): Boolean {
        return params.all { !it.required || it.required && it.hasValue() }
    }

    fun areAllParamsValid(): Boolean {
        return params.all { it.isValid() }
    }

}