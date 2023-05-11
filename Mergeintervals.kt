
/**
 *
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return
 * an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 */


fun main() {
    println(merge(arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)))) //1,5
    println(merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6)))) //1,6
    println(merge(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3)))) //1,4
    println(
        merge(
            arrayOf(
                intArrayOf(1, 1),
                intArrayOf(2, 2),
                intArrayOf(0, 0),
                intArrayOf(2, 3),
                intArrayOf(1, 3),
                intArrayOf(3, 5),
                intArrayOf(2, 3),
                intArrayOf(3, 5)
            )
        ).forEach {
            println()
            it.forEach {
                print("$it ")
            }
        }
    ) //0,0 1,1 2,5
    println(
        merge(
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18)
            )
        ).forEach {
            println()
            it.forEach {
                print("$it ")
            }
        }
    ) //1,6 / 8,10 / 15/18
}

fun merge(intervals: Array<IntArray>): Array<IntArray> {
    val sorted = intervals.sortedBy { it[0] }
    val result = mutableSetOf<IntArray>()
    fun compareIntervalsAndSave(array: Array<IntArray>) {
        var x = Pair(array.first().first(), array.first().last())
        array.forEach {
            if (x.second >= it.first()) {
                x = x.first to maxOf(x.second, it.last())
            } else {
                result.add(intArrayOf(x.first, x.second))
                x = it.first() to it.last()
            }
        }.also {
            result.add(intArrayOf(x.first, x.second))
        }
    }
    compareIntervalsAndSave(sorted.toTypedArray())
    return result.toTypedArray()
}
