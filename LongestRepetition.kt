/**
 * Description at
 * https://www.codewars.com/kata/586d6cefbcc21eed7a001155/kotlin
 *
 */

fun main() {
    println(longestRepetition("aaaabb")) //Pair('a',4)
    println(longestRepetition("bbbaaabaaaa")) //Pair('a',4)
    println(longestRepetition("cbdeuuu900")) //Pair('u',3)
    println(longestRepetition("")) //Pair(null,0)
    println(longestRepetition("ba")) //Pair('b',1)

}

fun longestRepetition(s: String): Pair<Char?, Int> {
    val resultList = mutableListOf<Pair<Char?, Int>>()
    var ch: Char? = s.firstOrNull()
    var count = 0
    s.forEach {
        if (ch == it) {
            count += 1
        } else {
            resultList.add(ch to count)
            ch = it
            count = 1
        }
    }.also { resultList.add(ch to count) }
    return resultList.maxBy { it.second }
}
