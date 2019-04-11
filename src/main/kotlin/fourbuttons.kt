interface Button {
    fun toggle()
}

interface Room {
    /** @return an array of 4 buttons - where the order is always the same, but the
     */
    fun getButtons(): Array<Button>
}

/*
             A Coop       A Betrays

   B Coop    A+2, B+2     A+3, B+0

   B Betrays A+0, B+3     A+1, B+1


 */






class InternalRoom() {

    class InternalButton(var state: Boolean) : Button {
        override fun toggle() {
            state = !state
        }
    }
}


interface MyPrisoner1 {
    fun init(info: Information)
    fun newPairingWithOtherProgram()
    fun doYouWishToCooperateGiven(otherProgramsLastChoicesAgainstYou: Array<Boolean>): Boolean
}

interface Information {
    fun getMyScore(): Int
}

