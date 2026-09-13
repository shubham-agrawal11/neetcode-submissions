class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var h = nums.size - 1

        while (l <= h) {
            val m = l + (h-l)/2
            if (nums[m] == target) {
                return m
            }
            if (nums[m] >= nums[l]) {
                if (target > nums[m] || target < nums[l]) {
                    l = m + 1
                } else {
                    h = m - 1
                }
            } else {
                if (target < nums[m] || target > nums[h]) {
                    h = m - 1
                } else {
                    l = m + 1
                }
            }
        }
        return -1
    }
}
