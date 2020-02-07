package function_definitions

/*





 _     _    _______    _______    _          _    _______
(_)   | |  (_______)  (_______)  (_)        | |  (_______)
 _____| |   _     _       _       _         | |   _     _
|  _   _)  | |   | |     | |     | |        | |  | |   | |
| |  \ \   | |___| |     | |     | |_____   | |  | |   | |
|_|   \_)   \_____/      |_|     |_______)  |_|  |_|   |_|

 _     _    _______    _     _    ______      ______        ______
(_)   (_)  (_______)  (_)   (_)  (_____ \    / _____)      (_____ \
 _______    _     _    _     _    _____) )  ( (____          ____) )
|  ___  |  | |   | |  | |   | |  |  __  /    \____ \        / ____/
| |   | |  | |___| |  | |___| |  | |  \ \    _____) )      | (_____
|_|   |_|   \_____/    \_____/   |_|   |_|  (______/       |_______)









     _            ___  _         _
    | |          / __)(_)       (_)
  __| | _____  _| |__  _  ____   _  ____    ____
 / _  || ___ |(_   __)| ||  _ \ | ||  _ \  / _  |
( (_| || ____|  | |   | || | | || || | | |( (_| |
 \____||_____)  |_|   |_||_| |_||_||_| |_| \___ |
    ___                              _    (_____|
   / __)                        _   (_)
 _| |__  _   _  ____    ____  _| |_  _   ___   ____    ___
(_   __)| | | ||  _ \  / ___)(_   _)| | / _ \ |  _ \  /___)
  | |   | |_| || | | |( (___   | |_ | || |_| || | | ||___ |
  |_|   |____/ |_| |_| \____)   \__)|_| \___/ |_| |_|(___/







 */












/*



    modifiers? 'fun' typeParameters?
    (receiverType '.')?
    simpleIdentifier functionValueParameters
    (':' type)? typeConstraints?
    functionBody?


 */









//
//fun addOne(input: Int) = input + 1









//
//fun Int.addOne(): Int {
//    return this + 1
//}
//
//













fun `add $% one`(input: Int): Int {
    return input + 1
}

















fun printAllNonEmptyString(strings: List<String>) {
    fun printStringIfNotEmpty(string: String) {
        if (string.isNotEmpty()) println(string)
    }
    strings.forEach { printStringIfNotEmpty(it) }
}
