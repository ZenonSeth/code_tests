

interface iface1 {
    fun run(): String? = "asdf"
}

interface iface2 {
    fun run(): String? = "asdf2"
}

abstract class acls {
    open fun run(): String? = null
}

class impl : acls(), iface1, iface2 {
    override fun run(): String? {
        return super<acls>.run() ?: super<iface1>.run() ?: super<iface2>.run()
    }
}


