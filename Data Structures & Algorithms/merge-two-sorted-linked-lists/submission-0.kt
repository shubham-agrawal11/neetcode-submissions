/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        var p1 = list1
        var p2 = list2
        val dummy = ListNode(0)
        var newL: ListNode? = dummy

        while (p1 != null && p2 != null) {
            if (p1.`val` < p2.`val`) {
                newL?.next = p1
                p1 = p1?.next
            } else {
                newL?.next = p2
                p2 = p2?.next
            }
            newL = newL?.next
        }
        newL?.next = p1 ?: p2 // add remaining nodes
        return dummy?.next
    }
}
