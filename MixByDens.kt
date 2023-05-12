/**
 *
 * Given a two-dimensional array representation of a glass of mixed liquids, sort the array such that the liquids appear
 * in the glass based on their density. (Lower density floats to the top) The width of the glass will not change from
 * top to bottom.
 * ======================
 * |   Density Chart    |
 * ======================
 * | Honey   | H | 1.36 |
 * | Water   | W | 1.00 |
 * | Alcohol | A | 0.87 |
 * | Oil     | O | 0.80 |
 * ----------------------
 */


fun main() {
    println(
        mixByDens(
            arrayOf(
                charArrayOf('H', 'H', 'W', 'O'),
                charArrayOf('W', 'W', 'O', 'W'),
                charArrayOf('H', 'H', 'O', 'O')
            )
        )
    )
    /** ['O','O','O','O'],
     *  ['W','W','W','W'],
     *  ['H','H','H','H'] */
    println(
        mixByDens(
            arrayOf(
                charArrayOf('A', 'A', 'O', 'H'),
                charArrayOf('A', 'H', 'W', 'O'),
                charArrayOf('W', 'W', 'A', 'W'),
                charArrayOf('H', 'H', 'O', 'O')
            )
        )
    )
    /** ['O','O','O','O']
     *  ['A','A','A','A']
     *  ['W','W','W','W']
     *  ['H','H','H','H'] */
    println(
        mixByDens(
            arrayOf(
                charArrayOf('A', 'H', 'W', 'O')
            )
        )
    )
    /** ['O','A','W','H'] */
    println(
        mixByDens(
            arrayOf(
                charArrayOf('A'),
                charArrayOf('H'),
                charArrayOf('W'),
                charArrayOf('O')
            )
        )
    )
    /** [['O'],['A'],['W'],['H']] */
    println(
        mixByDens(
            arrayOf(
                charArrayOf()
            )
        )
    )
    /** [] */
}

fun mixByDens(list: Array<CharArray>): List<List<Char>> {
    val densMap = mapOf('O' to 0, 'A' to 1, 'W' to 2, 'H' to 3)
    return if (list[0].isEmpty()) {
        listOf(listOf())
    } else {
        list.reduce { acc, chars ->
            acc + chars
        }.sortedBy {
            densMap[it]
        }.chunked(list[0].size)
    }
}
