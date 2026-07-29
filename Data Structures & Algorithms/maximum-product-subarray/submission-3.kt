class Solution {
    fun maxProduct(nums: IntArray): Int {
        // Prefix and suffix solution
        var prefix = 1
        var suffix = 1
        var max = nums[0]

        for (i in nums.indices) {
            if (prefix == 0) prefix++
            prefix *= nums[i]

            if (suffix == 0) suffix++
            var fromLast = nums.size - 1 - i
            suffix *= nums[fromLast]

            max = maxOf(max, prefix, suffix)
        }
        return max
    }
}
