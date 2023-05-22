/**
* Complete the function scramble(str1, str2) that returns true if a portion of str1 characters can be rearranged to match str2, otherwise returns false.
*/

fun main() {
    val s1 = "abcdefghijklmnopqrstuvwxyz".repeat(10000)
    val s2 = "zyxcba".repeat(9000)
    println(scrumble(s1, s2))
    println(scrumble("bbb", "a"))
}

fun scrumble(strOne: String, strTwo: String): Boolean {
    for (i in strTwo.toSet()) {
        if (strTwo.count { c -> c == i } < strOne.count { c -> c == i }) return false
    }
    return true
}
