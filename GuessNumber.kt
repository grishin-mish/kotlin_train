/**
 * The API guess is defined in the parent class.
 * @param  num   your guess
 * @return         -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * fun guess(num:Int):Int {}
 */

fun main() {
    println(Solution.guessNumber(2147483647))
}

object Solution {
    private val picked = 2147483647
    fun guess(num: Int): Int {
        return when {
            num < picked -> 1
            num > picked -> -1
            num == picked -> 0
            else -> -2
        }
    }

    fun guessNumber(n: Int): Int {
        var high : Long = (n.toLong() + 1)
        var low : Long = 1
        var mid : Long= (high + low)/2 + low
        while (guess(mid.toInt()) != 0) {
            when (guess(mid.toInt())) {
                -1 -> {
                    high = mid
                    mid = (high + low)/2
                    guess(mid.toInt())
                }

                1 -> {
                    low = mid
                    mid = (high + low)/2
                    guess(mid.toInt())
                }
            }
        }
        return mid.toInt()
    }
}
