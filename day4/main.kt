import params.ParamFactory
import java.io.File
import kotlin.Array

/**
 * Program params:
 * 0 - file path to input
 */
fun main(args: Array<String>) {
    val filePath = args[0]
    val passports = Passports();
    File(filePath).forEachLine {
        if (it.isBlank()) {
            passports.finishPassport()
        } else {
            passports.setLastPassportData(it)
        }
    }
//    part 1
    println(passports.countPasswordsWithRequiredFieldsFilled())
//    part 2
    println(passports.countValidPasswords())


}
