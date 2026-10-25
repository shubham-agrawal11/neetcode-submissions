/*
// Definition for a Node.
class Node(var `val`: Int) {
    var next: Node? = null
    var random: Node? = null
}
*/

class Solution {
    fun copyRandomList(head: Node?): Node? {
        if (head == null) {
            return null
        }

        var l1: Node? = head
        while (l1 != null) {
            var l2 = Node(l1.`val`)
            l2.next = l1.random
            l1.random = l2
            l1 = l1?.next
        }

        var newHead = head.random

        l1 = head
        while (l1 != null) {
            var l2 = l1.random
            if (l2 != null) {
                l2.random = l2.next?.random
            }
            l1 = l1.next
        }

        l1 = head
        while (l1 != null) {
            var l2 = l1.random
            l1.random = l2?.next
            if (l2 != null) {
                l2.next = l1.next?.random
            }
            l1 = l1.next
        }

        return newHead
    }
}
