
@file:JvmName("inline_kt")

typealias MyPass = String
typealias Username = String

inline class Password(val str: String) {
    fun obfuscated() : String = "***"
}

fun main() {

    val pass = Password("test")

    //val pass2: Password = ""
    val usr: Username = "asdf"



    inline_class.showPwd(pass)
    inline_class.showPwd2(Username(), MyPass())

}


inline fun <T>generic_non_r (v: T) {

}

inline fun <reified T>generic_r (v: T) {

}


object inline_class {


    fun showPwd(pass: Password) {

    }

    fun showPwd2(pass: MyPass, username: Username) {

    }
}