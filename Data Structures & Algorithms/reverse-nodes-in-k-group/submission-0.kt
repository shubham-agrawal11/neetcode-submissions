/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    private fun getKthNode(curr: ListNode?, k: Int): ListNode? {
        var curr = curr
        var k = k
        while (curr != null && k > 0) {
            curr = curr?.next
            k--
        }
        return curr
    }
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var groupPrev: ListNode? = dummy

        while (true) {
            // Find kthNode
            val kthNode = getKthNode(groupPrev, k)
            if (kthNode == null) {
                break
            }
            var groupNext = kthNode.next

            // Reverse list
            var prev: ListNode? = groupNext
            var curr = groupPrev!!.next
            while(curr != groupNext) {
                var nextNode = curr?.next
                curr?.next = prev
                prev = curr
                curr = nextNode
            }

            val tmp = groupPrev.next
            groupPrev.next = kthNode
            groupPrev = tmp
        }
        return dummy.next
    }
}
