class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1

        var max = 0

        while (left < right) {
            var l = heights[left]
            var r = heights[right]

            val area = (right-left) * minOf(l, r)
            max = maxOf(max, area)

            if (l < r) {
                left++
            } else {
                right--
            }
        }
        return max
    }
}
