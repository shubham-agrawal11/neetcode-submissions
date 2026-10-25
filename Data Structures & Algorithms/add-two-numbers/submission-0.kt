/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var n1 = l1
        var n2 = l2
        var dummy = ListNode(0)
        var newL: ListNode? = dummy

        var carry = 0
        while (n1 != null || n2 != null) {
            val v1 = n1?.`val` ?: 0
            val v2 = n2?.`val` ?: 0

            var sum = v1 + v2 + carry
            var lastDigit = sum % 10
            carry = 0
            if (sum > 9) {
                carry = 1
            }
            
            newL?.next = ListNode(lastDigit)

            newL = newL?.next
            n1 = n1?.next
            n2 = n2?.next
        }
        if (carry == 1) {
            newL?.next = ListNode(1)
        }
        return dummy?.next
    }
}
