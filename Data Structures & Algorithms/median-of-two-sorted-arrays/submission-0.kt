class Solution {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        var A = nums1
        var B = nums2
        var total = A.size + B.size
        var requiredLeftLength = (total + 1) / 2

        if (B.size < A.size) {
            A = nums2
            B = nums1
        }

        var l = 0
        var r = A.size
        while (l <= r) {
            var m = (l + r) / 2

            val len1 = m
            val len2 = requiredLeftLength - len1

            val l1 = if (len1 > 0) A[len1 - 1] else Int.MIN_VALUE
            val r1 = if (len1 < A.size) A[len1] else Int.MAX_VALUE
            val l2 = if (len2 > 0) B[len2 - 1] else Int.MIN_VALUE
            val r2 = if (len2 < B.size) B[len2] else Int.MAX_VALUE

            if (l1 <= r2 && l2 <= r1) {
                val median: Double = if (total % 2 == 0) {
                    (maxOf(l1.toDouble(), l2.toDouble()) + minOf(r1.toDouble(), r2.toDouble())) / 2
                } else {
                    maxOf(l1.toDouble(), l2.toDouble())
                }
                return median
            } else if (l1 > r2) {
                r = m - 1
                continue
            } else {
                l = m + 1
                continue
            }
        }
        return -1.0
    }
}
