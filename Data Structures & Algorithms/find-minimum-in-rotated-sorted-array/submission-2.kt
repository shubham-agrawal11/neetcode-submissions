class Solution {
    fun findMin(nums: IntArray): Int {
        // var min = nums[0]
        var l = 0
        var h = nums.size - 1

        // [6,1,2,3,4,5] // first half
        // [3,4,5,6,1,2] // second half
        // [5,6,1,2,3,4] // mid
        // [2,3,4,5,6,1] // last

        while (l < h) {
            val m = l + (h-l)/2
            if (nums[m] < nums[h]) {
                h = m
            } else {
                l = m + 1
            }
        }
        return nums[l]
    }
}
