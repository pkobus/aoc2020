import params.ParamFactory

object PassportFactory {

    fun createPassword() = Passport(ParamFactory.createParams())

}