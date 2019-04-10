package twocolumns

/**
 * Written by Milcho on 11/26/2018.
 */

fun main(args: Array<String>) {

    equalizeColumns(splitColumns(mutableListOf(4,4,3,3,3,1)))
}

class ShortAndTallColumns(
        shortColumn: MutableList<Int>?,
        tallColumn: MutableList<Int>?,
        shortHeight: Int,
        tallHeight: Int,
        noColumn: String?
) {
    var ShortColumn = shortColumn
    var TallColumn = tallColumn
    var NoColumn = noColumn?.also { println(noColumn) }
    var mShortHeight = shortHeight
    var mTallHeight = tallHeight
}

fun RemoveTooLargeItem(column: MutableList<Int>): MutableList<Int> {
    return if (column.isEmpty() || column[column.size - 1] <= column.sum() / 2) {
        column
    } else {
        column.removeAt(column.size - 1)
        RemoveTooLargeItem(column)
    }
}

fun splitColumns(column: MutableList<Int>): ShortAndTallColumns {
    column.sort()
    val ColumnA = mutableListOf<Int>()
    var ColumnATotal: Int = 0
    val ColumnB = mutableListOf<Int>()
    var ColumnBTotal: Int = 0
    val mColumn = RemoveTooLargeItem(column)
    val noColumn = "No solution possible"

    if (mColumn.isEmpty()) {
        return ShortAndTallColumns(null, null, 0, 0, noColumn)
    } else {
        var mMaxIndex = mColumn.size - 1

        for (i in 0..mMaxIndex) {
            if (i % 2 == 0) {
                ColumnA.add(mColumn[i])
                ColumnATotal += mColumn[i]
            } else {
                ColumnB.add(mColumn[i])
                ColumnBTotal += mColumn[i]
            }
        }
        when (ColumnATotal < ColumnBTotal) {
            true -> return ShortAndTallColumns(ColumnA, ColumnB, ColumnATotal, ColumnBTotal, null)
            false -> return ShortAndTallColumns(ColumnB, ColumnA, ColumnBTotal, ColumnATotal, null)
        }
    }
}

fun updateColumns(
        columnA: MutableList<Int>,
        columnB: MutableList<Int>,
        totalA: Int,
        totalB: Int,
        AisTaller: Boolean
): ShortAndTallColumns {
    when (AisTaller) {
        true -> return ShortAndTallColumns(columnB, columnA, totalB, totalA, null)
        false -> return ShortAndTallColumns(columnA, columnB, totalA, totalB, null)
    }
}

fun equalizeColumns(columns: ShortAndTallColumns): ShortAndTallColumns {
    var mTall = columns.TallColumn
    var mShort = columns.ShortColumn
    var mTallHeight = columns.mTallHeight
    var mShortHeight = columns.mShortHeight
    var mDifference = mTallHeight - mShortHeight
    if (mDifference == 0) {
        return ShortAndTallColumns(
                mShort,
                mTall,
                mShortHeight,
                mShortHeight,
                "Solution is $mShortHeight: $mShort $mTall"
        )
    } else {

        if (mTall!![0] >= mDifference) {
            mTallHeight -= mTall!![0]
            mTall.removeAt(0)
            mTall.sort()
        } else {
            mShort!!.add(0, mTall!![0])
            mTallHeight -= mTall!![0]
            mTall.removeAt(0)
            mShortHeight += mShort[0]
            mShort.sort()
        }
        val mShortTallColumns: ShortAndTallColumns =
                updateColumns(mTall, mShort!!, mTallHeight, mShortHeight, mTallHeight > mShortHeight)
        return equalizeColumns(mShortTallColumns)
    }
}