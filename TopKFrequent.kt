/**
 *
 * Given an integer array nums and an integer k, return the k most frequent elements.
 * You may return the answer in any order.
 *
 */


fun main() {
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3), 2)) // [1,2]
    println(topKFrequent(intArrayOf(1, 1, 1, 2, 2, 3, 3, 3, 3, 3, 3), 2)) // [3,1]
    println(topKFrequent(intArrayOf(1), 1)) // [1]
}

fun topKFrequent(nums: IntArray, k: Int): IntArray {
    return nums.groupBy { it }.toList().sortedByDescending { it.second.size }.take(k).map { it.first }.toIntArray()
}
