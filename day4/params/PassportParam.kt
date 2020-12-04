package params

class PassportParam(val name: String, val required: Boolean, private val validator: Validator) {

    private var value = ""

    fun setValue(value: String) {
        this.value = value;
    }

    fun hasValue(): Boolean {
        return value != ""
    }

    fun isValid(): Boolean {
        return validator.isValid(value)
    }
}