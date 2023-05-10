/**
 *
 * Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water),
 * return the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 */
import java.util.*

fun main() {
    //1
    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '1', '1', '0'),
                charArrayOf('1', '1', '0', '1', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '0', '0', '0')
            )
        )
    )
    //3
    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('1', '1', '0', '0', '0'),
                charArrayOf('0', '0', '1', '0', '0'),
                charArrayOf('0', '0', '0', '1', '1')
            )
        )
    )
    //4
    println(
        Solution.numIslands(
            arrayOf(
                charArrayOf('0', '1', '0'),
                charArrayOf('1', '0', '1'),
                charArrayOf('0', '1', '0')
            )
        )
    )
}

object Solution {

    fun numIslands(grid: Array<CharArray>): Int {
        var matrix = grid
        val m = matrix.size
        val n = matrix[0].size
        var islandCount = 0

        fun findIsland(coord: Pair<Int, Int>) {
            val collection = ArrayDeque<Pair<Int, Int>>().apply { this.offer(coord) }
            while (collection.isNotEmpty()) {
                if (collection.first().first > 0 && matrix[collection.first().first - 1][collection.first().second] == '1') {
                    collection.add(collection.first().first - 1 to collection.first().second)
                    matrix[collection.first().first - 1][collection.first().second] = '0'
                }
                if (collection.first().first < m - 1 && matrix[collection.first().first + 1][collection.first().second] == '1') {
                    collection.add(collection.first().first + 1 to collection.first().second)
                    matrix[collection.first().first + 1][collection.first().second] = '0'
                }
                if (collection.first().second > 0 && matrix[collection.first().first][collection.first().second - 1] == '1') {
                    collection.add(collection.first().first to collection.first().second - 1)
                    matrix[collection.first().first][collection.first().second - 1] = '0'
                }
                if (collection.first().second < n - 1 && matrix[collection.first().first][collection.first().second + 1] == '1') {
                    collection.add(collection.first().first to collection.first().second + 1)
                    matrix[collection.first().first][collection.first().second + 1] = '0'
                }
                matrix[collection.first().first][collection.first().second] = '0'
                collection.poll()
            }
        }

        matrix.forEach {
            var count = 0
            it.forEach { c ->
                if (c == '1') {
                    findIsland(grid.indexOf(it) to count)
                    islandCount += 1
                }
                count += 1
            }
        }
        return islandCount
    }
}
