package adventofcode

/**
 * Written by Milcho on 12/3/2018.
 */

val input2 = listOf("fzostwblnqkhpuzxirnevmaycq",
        "fzastwblgqkupujxirnevmaucd",
        "fzostwbxgakhpujxirnevmayci",
        "uzosmwblgqkhlujxirnevmaycd",
        "bzostwblgqkhpujxirnenfaycd",
        "fzostwblghkhpujxibneemaycd",
        "fzostwblgrkkpujxirnevqaycd",
        "fzostwblgqkhpkjxirqkvmaycd",
        "fzostwblgqdxpujbirnevmaycd",
        "fzostwblgykhfujxirfevmaycd",
        "fzostwbvgskhpujxirnevmagcd",
        "flostwblgokhpuixirnevmaycd",
        "fzostwblgzkhppjxirnevxaycd",
        "ftosuwblgqkhpujxirnevmeycd",
        "fzostkblgqkzpujxirnrvmaycd",
        "fuostwbugqkhnujxirnevmaycd",
        "frostwblgqkhpujsirneamaycd",
        "bzostwblgqkhpajxirnevmuycd",
        "fzysttbluqkhpujxirnevmaycd",
        "czostgblgqkhpujxirnevmgycd",
        "fzostwbcgqkhpujxirnevmavcr",
        "vzostwbdgqrhpujxirnevmaycd",
        "fzostwblgxkhpujxirnekmdycd",
        "fzostwblgdkspzjxirnevmaycd",
        "fzoqtwblgquhpujxirnevkaycd",
        "fzostwblgqjhfujxirnevmayzd",
        "fyostwblgtkhpujxilnevmaycd",
        "izostwblzqkhpupxirnevmaycd",
        "fzoaurblgqkhpujxirnevmaycd",
        "fzostjblgqkhpbjxirbevmaycd",
        "fzostwblgqkhpujmirngvmayca",
        "fxostwbhgqkhiujxirnevmaycd",
        "fzostwblngkhpujxirnemmaycd",
        "fzosgwblgqkhpujxirnlvqaycd",
        "bpostwblgqkhxujxirnevmaycd",
        "fzhstwblgqshpujxirnepmaycd",
        "fzootwbegqkhwujxirnevmaycd",
        "fzmstwblgqkhmujxirnevsaycd",
        "fzostwolgqkhpujxirnevmaysp",
        "foostwblgqohpujxirnevmayyd",
        "fzostwblgqkhgujxgrnevqaycd",
        "fzostwbltqkhjujxipnevmaycd",
        "fsostwblgqkhfujxirnevmayck",
        "fzostwmlgqkbpujxifnevmaycd",
        "fdostwblgqkhsujxirnecmaycd",
        "fzostwblgquhpejxiinevmaycd",
        "fzoqtwblgqkhkujxirnevmaywd",
        "fzostwblmqkmpujxirnyvmaycd",
        "fzjstwblgqkhpuyxirneomaycd",
        "fzortwblgqkhpzjxprnevmaycd",
        "fzosnwulgqkhpujxirnevpaycd",
        "fzostwbegqkvpujxirnevmaykd",
        "fzostwylzqkypujxirnevmaycd",
        "fioshwblgqehpujxirnevmaycd",
        "fzostwbliqkhoujxirnesmaycd",
        "fzostwblgqkhpujdirnelmqycd",
        "fzmstwblgqkhpujxirnnvpaycd",
        "fzostwbtgqkhcujxirnevmaycz",
        "fzostwblgqkfpujeignevmaycd",
        "fzostwbegqkhpuvxirndvmaycd",
        "fzostwblgqkcpujxmrnevmaycp",
        "fvostwblgqkhpyjxirnevmaycx",
        "fzostwblgqkhpufxirnevmzacd",
        "fzisjwblglkhpujxirnevmaycd",
        "fzosowbliqkhgujxirnevmaycd",
        "fzostwblgqkhpujxirnyvmaywl",
        "fzostwbllqnzpujxirnevmaycd",
        "fzostwblgquhpujxirneomayci",
        "fzostwblgqjepujximnevmaycd",
        "fzostwblgqrhbujxijnevmaycd",
        "fzostoblgqkhpujxirnevmoynd",
        "fzortwblgqkhpujxixnevjaycd",
        "fzostwhlgqkapujxirnevmaych",
        "fzostwblgakhpujxirnevfayct",
        "faostwblgqohpljxirnevmaycd",
        "fzostwbhgqkhpujxirnyvcaycd",
        "fjostwblgqkhpwjxirnevjaycd",
        "fzostwblgqklpuixirnevmayxd",
        "fzostwblgqkhhujxirncvmayce",
        "fzostwblzqkhpzjxkrnevmaycd",
        "fzostwblqqkbpujxirnevmcycd",
        "ffostwblxqkhpujxirnevmayxd",
        "fzostwblgqkhpbuxirnefmaycd",
        "szostiblgqkhpujxirnevoaycd",
        "fhlstwblgqkhpujxirnevmaycb",
        "fzostwblgwfhpujxirnevmayed",
        "fyostwblgqkhzujxirnevmayjd",
        "fzostwblgqkvrujxirnevmaucd",
        "fzestwblghkhpujxirnevmaycq",
        "foostwbkgqkhhujxirnevmaycd",
        "fpxstwblgqkhpujxirzevmaycd",
        "fsostwtlgqmhpujxirnevmaycd",
        "feostwelgqkhpumxirnevmaycd",
        "fzostwbvgqkhpujkirnevmayce",
        "fzmsewblgqahpujxirnevmaycd",
        "fzsstsblgkkhpujxirnevmaycd",
        "fzostwblgqkhxajxirneumaycd",
        "fzostwblmqkhpujyisnevmaycd",
        "gzostwblgqkhphjxirnevmavcd",
        "fzostwblgckgpujxirnzvmaycd",
        "qzostdblgqkhpujxirnevmaywd",
        "fzoshwblgskhpufxirnevmaycd",
        "fzosdwblgqkhpujkirnevjaycd",
        "fzvstwblgqkhpuixdrnevmaycd",
        "szostwblgqxhpujeirnevmaycd",
        "fzosvwblgtkhpujxirnevmoycd",
        "fzoscwblgqkkpujxirnevmvycd",
        "fzostsblgqnlpujxirnevmaycd",
        "fzostwblgmkhpujxlrnevjaycd",
        "fzosnwblgqklpugxirnevmaycd",
        "fcostwblgqpmpujxirnevmaycd",
        "ozostwblgbkhpujxirnevmafcd",
        "fzostwbagqkhiujxirneemaycd",
        "fzosxwblgqkhpumxirneymaycd",
        "fpostkblgqkhpujxianevmaycd",
        "fzostwblgvkhhujxirnevmaycl",
        "fzobtwtlgqkhpuwxirnevmaycd",
        "fzostwvwgqkhpujxirtevmaycd",
        "xzostwglgqkhpujtirnevmaycd",
        "fzostwblgvkhtujxirnzvmaycd",
        "jzostwblgqkhpujxirrevmvycd",
        "pzostwbagqkhpujxirnevjaycd",
        "fzostwclgqkhpujxirnhvmeycd",
        "fzostwblglkhpujxirnevmayrf",
        "fzoskwblnqkhpujxirnevmaysd",
        "fzostbblgqkhpujxirnevmjycw",
        "fzostwblggobpujxirnevmaycd",
        "fzostwblgckhpijxirnevmayxd",
        "fiostwrlgqkhpujxirnevmayck",
        "frfstwblvqkhpujxirnevmaycd",
        "fzowvwblgqkhpujsirnevmaycd",
        "fzostwblgquhgujxirnevmiycd",
        "fzoztwblgqkhpujxvrnevmaycj",
        "fzostnbtgqkhpujxixnevmaycd",
        "fzfstwblgjkrpujxirnevmaycd",
        "fzostwblpqkhpdrxirnevmaycd",
        "fivstwblgqkhpuixdrnevmaycd",
        "fzostwbpgqkhpdjxirnewmaycd",
        "fzostwblgqkhpdjxsrngvmaycd",
        "fzostwblsqkhpujxisnxvmaycd",
        "fcosvwblgqkhpujxirnevmavcd",
        "fzostwrlgekhgujxirnevmaycd",
        "fzostwblgqkhpujxindeimaycd",
        "uzostwblgqshpujxirnevmwycd",
        "fzostwzliqkhpujxirnevmaycu",
        "zzostwbtgqkhpijxirnevmaycd",
        "fzoltwblgqkhpujxinncvmaycd",
        "fzostwblgqkzpujxprnevmayhd",
        "fqostwblgqkhpujrirnevmzycd",
        "jzostwblgqkhpuzxkrnevmaycd",
        "fzostwblgqkhpuwxirszvmaycd",
        "fzostwblgqkhpxjxilnevdaycd",
        "fpmstwblgqkhpujxirnwvmaycd",
        "fzoejwblqqkhpujxirnevmaycd",
        "fzostwblgkshzujxirnevmaycd",
        "fzoatqblgqxhpujxirnevmaycd",
        "fzostwblgpkhpujiipnevmaycd",
        "fzostwblgqghpujgbrnevmaycd",
        "izosowblgqkhpujxirnejmaycd",
        "fzostwblgqthpujxjrnevmalcd",
        "fzovtwbcgqkhpujxicnevmaycd",
        "fzoatwblgqkhpujxidntvmaycd",
        "kzpstwblgqihpujxirnevmaycd",
        "fzosawnlgqkhpujxibnevmaycd",
        "fzostwblgqkhpujxarnevdajcd",
        "bzostwblgqkhpujxvrnevmrycd",
        "fzostwblgqkhpwfxirnevmazcd",
        "fzostwblgqknpujyiqnevmaycd",
        "zzostwblgqkhpujyirneqmaycd",
        "flosiwblgqihpujxirnevmaycd",
        "fzoetwblgqkhxujxirnevmeycd",
        "fznstwbugqkhpujxibnevmaycd",
        "fzbstwblgqkhpudxitnevmaycd",
        "fzostwblgqkhkujxirnexaaycd",
        "fzohthblgqkhpujxiknevmaycd",
        "fzostwblgqkhpujxirnevvayjt",
        "fzostwblggkhpujxirnrvqaycd",
        "fzostwblgqslpujxirnevmaysd",
        "aoostwblgqkhpnjxirnevmaycd",
        "fzostwblgqkhlutxirnevuaycd",
        "fxostwbugqkhpujxirnexmaycd",
        "fzoftwblgqkhpsjxirnevmaywd",
        "fzbstwblgqkhndjxirnevmaycd",
        "fzostwblgqkhpxjxipnlvmaycd",
        "fzostwbloqkhowjxirnevmaycd",
        "fzostwblgqkcpdjxirnevnaycd",
        "vzostiblgqkhpsjxirnevmaycd",
        "fzostwblgqkhazjxirnevmaycg",
        "fzostaklgqkhpujxirnevmaypd",
        "fzostwblgkkhppjxirnevpaycd",
        "izostwblgqkhpujairhevmaycd",
        "fzostwdlgqkhpuqxzrnevmaycd",
        "fzostwblgqkepujxernevmayct",
        "fzostdblgqkhpujxyrnehmaycd",
        "fzostwblgqkhsujxirnenfaycd",
        "fzostwblgqkhpujxifnevmajld",
        "fzostwblgokhpujxirxemmaycd",
        "fzastwblcqkhpujxiruevmaycd",
        "fzostwsxgqkhpuexirnevmaycd",
        "xzosxwblgqkhpujxirnetmaycd",
        "fzostwblgqkhpuexirnevmkccd",
        "fzostwblgqklpujxirnermfycd",
        "fzoetwblgqkhpujxirnehhaycd",
        "ffostwblgvkhpujxirnevmazcd",
        "fcosywblgqkhpujxirnevmaycy",
        "fzmstwblgqkhpujxdrnevmaycl",
        "fpostwblgqahpujxirnqvmaycd",
        "fzostwbmgqkhpulxornevmaycd",
        "fzostwblgqkopujxqrnevmrycd",
        "fzostwblgqkhpujxisnevmjgcd",
        "fzogtwulfqkhpujxirnevmaycd",
        "fzostwalgqkhpcjxirnevmayud",
        "fzosxwblgqkhpujxirnevmasmd",
        "fzostwblgrkowujxirnevmaycd",
        "fzostsblgqkhpujxirnevmsccd",
        "fzostwblgqkhpujxfrnnvmaocd",
        "fzostwblgqkhpujxiynsvkaycd",
        "fzosowblgqkhpwjxirnevmaecd",
        "fzosgwblgfkhpujxyrnevmaycd",
        "fzostsblgzkhpujmirnevmaycd",
        "fzostwblrqkhyuixirnevmaycd",
        "qzostwblgqkhpujxyrnevmvycd",
        "lzostwblgqkhpujxirqevmaymd",
        "fzostwblgqkbpujxirnefbaycd",
        "fzostwblgmihpujxirnevmafcd",
        "fzostmblgqkhpujxirnevmpynd",
        "fzoltwblgqkhpujlihnevmaycd",
        "fzostwblgqkhpujdirneviyycd",
        "fzgspwblgqkhpqjxirnevmaycd",
        "fzostwblgqkhtujkirnevmayld",
        "fjostwblgqkhpagxirnevmaycd",
        "fzpsthblgqkhpuzxirnevmaycd",
        "fzostwblgqkhpuhxzrneymaycd",
        "fzoftwblgqkepujxirnevcaycd",
        "fzostwblgqkbpyjxipnevmaycd",
        "fzostwqlgqkhpujxirjevmayad",
        "fzoxtwblgqkypupxirnevmaycd",
        "fzostwblgqwhpuoxiynevmaycd",
        "fzostwblgqkhpfjkirnevmavcd",
        "fzoqtwblgqkhpujxirnermaycp",
        "fzostwbngxkhpujxirnevmayqd",
        "fzostwqogqkhpcjxirnevmaycd",
        "fzostwblyqkhpujxvrnevmayzd",
        "vzostwblgqkhpujxirnevmlzcd",
        "fzostwblaqkhpujxirnevbajcd",
        "fdostwblgqkhpujxzrnevmayod",
        "fzostxbloqkhpujxirnevmcycd",
        "fzostwbcgqkhpyjxirnegmaycd",
        "fzostwblgqkhpuyxirnzrmaycd",
        "fzustwycgqkhpujxirnevmaycd")


fun main (args: Array<String>) {
    part2()
}

fun part2() {
    var commonId = "N/A"
    input2.forEachIndexed{i, inp ->
        val first = inp
        for (j in i+1 until input2.size) {
            val second = input2[j]
            first.forEachIndexed { index, c ->
                val res = findSingleCommon(first, second)
                if (res != null) {
                    commonId = first.replace(res.toString(), "")
                    println(commonId)
                }
            }
        }
    }
}

fun findSingleCommon(first: String, second: String): Char? {
    if (first.length != second.length) return null
    var diff: Char? = null
    first.forEachIndexed{i,ch ->
        if (ch != second[i]) {
            if (diff != null) return null
            diff = ch
        }
    }
    return diff
}

fun part1() {
    val duplicateCounts = HashMap<Int, Int>()
    input2.forEach{word ->
        val letterCount = HashMap<Char, Int>()
        word.forEach { letterCount[it] = letterCount[it]?.plus(1) ?: 1 }
        var dups = 0
        val timesCounted = mutableSetOf<Int>()
        letterCount.forEach { c, i ->
            if (i in 2..3 && !timesCounted.contains(i)) {
                duplicateCounts[i] = duplicateCounts[i]?.plus(1) ?: 1
                timesCounted.add(i)
            }
        }
    }
    var checksum = 1
    println(duplicateCounts)
    duplicateCounts.forEach{dup, times ->
        checksum *= times
    }
    println(checksum)
}