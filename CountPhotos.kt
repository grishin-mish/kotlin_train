/*
 * Description at
 * https://www.codewars.com/kata/6319dba6d6e2160015a842ed/train/python
 *
 */

fun main(args: Array<String>) {
    println(countPhotos(">>.")) //2
    println(countPhotos(".>>")) //0
    println(countPhotos(".>><<>..>><>.<><<><<<>...<.<><.......>>><<>><>.>.<..<><<<.>.><.>.>.<>.><><..>.<>..>><>>.<<.<.>.<<><.>...<>..<>...<><.<<<")) //1748
    println(countPhotos(".><.>>.<<")) //11
}

fun countPhotos(str: String): Int {
    var result = 0
    var camera = 0
    var forwardCar = 0
    str.forEach {
        when (it) {
            '.' -> {
                camera += 1
                result += forwardCar
            }

            '>' -> {
                forwardCar += 1
            }

            '<' -> {
                result += camera
            }
        }
    }
    return result
}
