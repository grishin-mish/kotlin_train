/**
 * Description at
 * https://www.codewars.com/kata/556deca17c58da83c00002db
 * 
 */

fun main() {
    tribonacci(doubleArrayOf(1.0, 1.0, 1.0), 10).forEach { println(it) }
    //1.0,1.0,1.0,3.0,5.0,9.0,17.0,31.0,57.0,105.0
}

fun tribonacci(signature: DoubleArray, n: Int): DoubleArray {
    val resultList = mutableListOf<Double>().also { it.addAll(signature.asList()) }
    var iter = n - resultList.size
    while (iter > 0) {
        resultList.add(resultList.takeLast(3).sum())
        iter -= 1
    }
    return resultList.toDoubleArray()
}
