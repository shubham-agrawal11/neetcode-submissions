/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head == null || head.next == null) return

        var slow = head
        var fast = head.next

        // find middle
        while (fast?.next != null) {
            slow = slow?.next
            fast = fast?.next?.next
        }

        // reverse second half of list
        var secondH = slow?.next
        slow?.next = null
        var prev: ListNode? = null
        var curr = secondH
        while (curr != null) {
            var temp = curr?.next
            curr.next = prev
            prev = curr
            curr = temp
        }

        // pick one from each side
        var first = head
        var second = prev
        while (first != null && second != null) {
            var temp1 = first?.next
            var temp2 = second?.next

            first?.next = second
            second?.next = temp1

            first = temp1
            second = temp2
        }
    }
}
