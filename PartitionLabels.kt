/**
 *
 * You are given a string s. We want to partition the string into as many parts as possible so that each
 * letter appears in at most one part.
 * Note that the partition is done so that after concatenating all the parts in order, the resultant string should be s.
 *
 * Return a list of integers representing the size of these parts.
 *
 */


fun main() {
    println(partitionLabels("ababcbacadefegdehijhklij")) //[9,7,8]
    println(partitionLabels("eccbbbbdec")) //[10]
}

fun partitionLabels(s: String): List<Int> {
    val list = 'a'..'z'
    val indices = mutableSetOf<Pair<Char, Pair<Int, Int>>>()
    val result = mutableListOf<Int>()
    list.forEach { c ->
        if (c in s) {
            indices.add(c to (s.toList().indexOfFirst { it == c } to s.toList().indexOfLast { c == it }))
        }
    }
    fun compareIntervalsAndSave(list: Set<Pair<Char, Pair<Int, Int>>>) {
        var x = list.first().second.first to list.first().second.second
        list.forEach {
            x = if (x.second >= it.second.first) {
                x.first to maxOf(x.second, it.second.second)
            } else {
                result.add(x.second - x.first + 1)
                it.second.first to it.second.second
            }
        }.also {
            result.add(x.second - x.first + 1)
        }
    }
    compareIntervalsAndSave(indices)
    return result
}
