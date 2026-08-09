class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        if (heights.size == 0) return 0

        var max = 0
        var stack = ArrayDeque<Pair<Int, Int>>()

        stack.addLast(0 to heights[0])
        for (i in 1 until heights.size) {
            var indexOfBiggestBefore = i
            while (heights[i] < (stack.peekLast()?.second ?: 0)) {
                val last = stack.peekLast()
                indexOfBiggestBefore = last.first
                var currentMax = (i - last.first) * last.second
                max = maxOf(max, currentMax)
                stack.removeLast()
            }
            stack.add(indexOfBiggestBefore to heights[i])
        }

        while (stack.isNotEmpty()) {
            val last = stack.removeLast()
            var currentMax = (heights.size - last.first) * last.second
            max = maxOf(max, currentMax)
        }

        return max
    }
}
