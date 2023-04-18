/**
 * Description at
 * https://www.codewars.com/kata/6417797d022e4c003ebbd575/train/python
 *
 */
 

import kotlinx.coroutines.*
import kotlin.random.Random

suspend fun main(args: Array<String>) {
    runBlocking {
        val list = List(23) { async { Server.sendRequest(it) } }
        val res = list.awaitAll()
        println(res.joinToString(""))
    }
}

object Server {
    private val str = generateString(23)
    suspend fun sendRequest(index: Int): Char {
        delay(1000)
        return str[index]
    }
}

fun generateString(n: Int): String {
    val pool: List<Char> = ('a'..'z') + ('A'..'Z')
    return pool.map { Random.nextInt(0, pool.size).let { pool[it] } }.joinToString("")
}
