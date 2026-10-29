/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        // Merge two adjacent lists until you have 1 list
        if (lists.isEmpty()) return null
        var finalList = lists.toList()

        while (finalList.size > 1) {
            val mergedLists = mutableListOf<ListNode?>()

            for (i in finalList.indices step 2) {
                val dummy = ListNode(0)
                var newL: ListNode? = dummy
                var p1 = finalList[i]
                var p2 = if (i+1 < finalList.size) finalList[i+1] else null 

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
                newL?.next = p1 ?: p2

                mergedLists.add(dummy?.next)
            }
            finalList = mergedLists
        }
        return finalList[0]
    }
}
