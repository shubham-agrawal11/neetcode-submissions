class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var left = 1
        var right = 0 // max value in piles

        for (pile in piles) {
            right = maxOf(right, pile)
        }
        var result = right

        while (left <= right) {
            val mid = left + (right - left) / 2

            var totalHours = 0
            for (pile in piles) {
                totalHours += pile/mid // time=dis/speed
                if (pile % mid != 0) totalHours++
            }

            if (totalHours <= h) {
                result = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return result
    }
}
