/**
 *
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 *
 */

fun main() {
    twoSum(intArrayOf(2,7,11,15), 9).forEach ( ::println )
    twoSum(intArrayOf(3,2,4), 6).forEach ( ::println )
    twoSum(intArrayOf(3,3), 6).forEach ( ::println )
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        if (map.contains(target - i)) {
            return intArrayOf(map.getValue(target - i), index)
        }
        map[i] = index
    }
    return intArrayOf()
}
