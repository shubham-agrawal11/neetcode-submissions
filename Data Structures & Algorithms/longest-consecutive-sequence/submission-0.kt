class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        var numSet = nums.toHashSet()
        var max = 0

        for (num in nums) {
            if (!numSet.contains(num)) {
                continue
            }

            var left = num
            var right = num

            while (numSet.contains(--left)) {
                numSet.remove(left)
            }
            while (numSet.contains(++right)) {
                numSet.remove(right)
            }
            var count = right - left - 1
            max = maxOf(max, count)
        }
        return max
    }
}
