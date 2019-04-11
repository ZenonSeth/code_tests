package queens

/*

n= total number of queens,
q = the position of the first queen,
i  = number of queen,
x= difference in position with next queen,
ListX = all x’s where 1-q<=x<= n-q and x !=any of (0,1,-1).
  (i, q, ListX,)
Do this for all i between 1 and n.
For each (i, q,) e.g, (i3, q2)keep only the x’s in List X if its sum with any x of a previous (i, q2) is != any of (this particular i - any previous i)x(0,1,-1)
If there are no x’s for a particular i corresponding to all qs at that i, then stop. Also drop any qs that don’t have corresponding x’s.
However, if we reach i = n, then the total number of solutions is the sum of the lengths of all the non-empty ListXs corresponding to all remaining qs at i= n-1

 */


fun main(args: Array<String>) {

}

fun solveQueens(boardSize: Int) {


}

