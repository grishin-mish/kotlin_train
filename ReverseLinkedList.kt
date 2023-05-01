/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

fun main() {
    var linkNode: ListNode? = null
    val list = mutableListOf<ListNode>()
    (0..2).forEach {
        if (it == 0) {
            var node = ListNode(it)
            linkNode = node
            list.add(node)
            println("added ${node.next}, link $linkNode")
        } else {
            var node = ListNode(it)
            node.next = linkNode
            linkNode = node
            list.add(node)
            println("added ${node.next}, link $linkNode")
        }
    }

    list.forEach { println("node $it, next one ${it.next}") }
    println("reversing")
    Solution.reverseList(list.last())
    list.forEach { println("node $it, next one ${it.next}") }
}

object Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prevNode: ListNode? = null
        var currentNode: ListNode? = head
        var nextNode: ListNode? = null
        while (currentNode != null) {
            nextNode = currentNode.next
            currentNode.next = prevNode
            prevNode = currentNode
            currentNode = nextNode
        }
        val headd = prevNode
        return headd
    }
}

class ListNode(var `value`: Int) {
    var next: ListNode? = null
}
