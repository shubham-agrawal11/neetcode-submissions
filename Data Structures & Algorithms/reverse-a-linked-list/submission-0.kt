/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var curr = head
        var prev: ListNode? = null

        while (curr != null) {
            val nextNode = curr.next
            curr?.next = prev
            prev = curr
            curr = nextNode
        }
        return prev
    }
}
