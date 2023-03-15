/**
 * Description at
 * https://www.codewars.com/kata/58235a167a8cb37e1a0000db/kotlin
 * 
 */

fun main() {
    println(numberOfPairs(listOf("red", "red")))//1
    println(numberOfPairs(arrayOf("red", "green", "blue").toList()))//0
    println(numberOfPairs(arrayOf("gray", "black", "purple", "purple", "gray", "black").toList()))//3
    println(numberOfPairs(arrayOf("red", "green", "blue", "blue", "red", "green", "red", "red", "red").toList()))//4
    println(numberOfPairs(emptyList<String>()))//0
}
 
 fun numberOfPairs(gloves: List<String>): Int {
    return gloves.groupingBy { it }.eachCount().map {
        it.value / 2
    }.sum()
}
