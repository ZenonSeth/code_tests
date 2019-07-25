

class Internal {
    internal fun doStuff(s: String) {

    }
}

abstract class BaseExtractor {

    internal open fun fillValues(item: Any, context: String): MutableMap<String, Any> {
        println("fillVals code")
        return mutableMapOf()
    }
}

class Extractor : BaseExtractor() {
    override fun fillValues(item: Any, context: String): MutableMap<String, Any> {
        println("override call")
        return super.fillValues(item, context)
    }

}