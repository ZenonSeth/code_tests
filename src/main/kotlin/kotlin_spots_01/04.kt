package kotlin_spots_01

/****************************************************************
 *  04
 ****************************************************************/
//
//open class View {
//    init {
//        update()
//    }
//
//    fun update() = updateBackground(getBackgroundColor())
//
//    private fun updateBackground(color: String) = println("Updating Background Color = $color")
//
//    open fun getBackgroundColor(): String = "0x00000000"
//}
//
//class MyView : View() {
//    var userBackgroundColor: String = "0xFFFFFFFF"
//        set(value) {
//            field = value
//            update()
//        }
//
//    override fun getBackgroundColor(): String {
//        //println("color = $userBackgroundColor")
//        return userBackgroundColor
//    }
//}
//
//fun main() {
//    val aView = MyView()
//    aView.userBackgroundColor = "0x33333333"
//}

/**
 * What will it print?
 * a) "Updating Background Color = true 0x33333333"
 * b) "Updating Background Color = true 0xFFFFFFFF"
 * c) "Updating Background Color = true 0x00000000"
 * d) Null pointer exception
 * e) Something else?
 */