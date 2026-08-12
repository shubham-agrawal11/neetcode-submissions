class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        // Binary search
        val rows = matrix.size
        val cols = matrix[0].size

        var l = 0
        var r = rows * cols - 1

        while (l <= r) {
            val m = (l+r) / 2
            var newR = m / cols
            var newC = m % cols

            when {
                matrix[newR][newC] < target -> l = m+1
                matrix[newR][newC] > target -> r = m-1
                else -> return true
            }
        }
        return false
    }
}
