/**
 *
 * Description at:
 * https://www.codewars.com/kata/52b305bec65ea40fe90007a7/train/python
 *
 */


fun main() {
    println(grabscrab("trisf", listOf("first")))   // [first]
    println(grabscrab("oob", listOf("bob", "baobab"))) // []
    println(grabscrab("ainstuomn", listOf("mountains", "hills", "mesa"))) //[mountains]
    println(grabscrab("oolp", listOf("donkey", "pool", "horse", "loop")))//[pool, loop]
    println(grabscrab("ortsp", listOf("sport", "parrot", "ports", "matey")))//[sport, ports]
}

fun grabscrab(said: String, possibleWords: List<String>): List<String> {
    val result = mutableListOf<String>()
    val ord = said.asSequence().sorted().joinToString("")
    possibleWords.forEach {
        if (it.asSequence().sorted().joinToString("") == ord) {
            result.add(it)
        }
    }
    return result
}

