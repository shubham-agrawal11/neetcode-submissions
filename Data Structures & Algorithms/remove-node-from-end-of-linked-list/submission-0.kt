/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var dummy = ListNode(0)
        dummy.next = head

        var left: ListNode? = dummy
        var right = head

        var num = n
        while (num > 0) {
            right = right?.next
            num--
        }

        while (right != null) {
            left = left?.next
            right = right?.next
        }
        
        left?.next = left?.next?.next
        return dummy?.next
    }
}
