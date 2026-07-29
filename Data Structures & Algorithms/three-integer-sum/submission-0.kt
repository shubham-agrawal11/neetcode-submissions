class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        
        var res = mutableSetOf<List<Int>>()

        for (i in nums.indices) {
            var l = i+1
            var r = nums.size - 1
            while (l < r) {
                var sum = nums[i] + nums[l] + nums[r]
                when {
                    sum > 0 -> r--
                    sum < 0 -> l++
                    else -> {
                        res.add(listOf(nums[i], nums[l], nums[r]))
                        l++
                        r--
                    }
                }
            }
        }
        return res.toList()
    }
}
