import java.util.Stack

/**
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 */

fun main() {
    println(isValid("()"))          //true
    println(isValid("()[]{}"))      //true
    println(isValid("(]"))          //false
    println(isValid("([)]"))        //false
    println(isValid("}[]"))        //false
    println(isValid("()(()"))        //false
}

fun isValid(s: String): Boolean {
    var stack: Stack<String> = Stack()
    s.forEach {
        when (it) {
            '(' -> stack.push("(")
            ')' -> if (stack.isEmpty() || !stack.peek().equals("(")) {
                return false
            } else stack.pop()
            '[' -> stack.push("[")
            ']' -> if (stack.isEmpty() || !stack.peek().equals("[")) {
                return false
            } else stack.pop()
            '{' -> stack.push("{")
            '}' -> if (stack.isEmpty() || !stack.peek().equals("{")) {
                return false
            } else stack.pop()
        }
    }
    return stack.isEmpty()
}
