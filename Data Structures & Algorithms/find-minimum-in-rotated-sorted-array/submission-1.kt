class Solution {
    fun findMin(nums: IntArray): Int {
        // var min = nums[0]
        var l = 0
        var h = nums.size - 1
        var m = l + (h-l)/2

        if (nums[l] < nums[h]) { // start
            return nums[l]
        }
        // [6,1,2,3,4,5] // first half
        // [3,4,5,6,1,2] // second half
        // [5,6,1,2,3,4] // mid
        // [2,3,4,5,6,1] // last

        while (true) {
            m = l + (h-l)/2
            if (nums[m] > nums[l]) {
                l = m
                continue
            }
            if (nums[m] < nums[l]) {
                h = m
                continue
            }
            if (nums[m] < nums[l] && nums[m] > nums[h]) {
                h = m
                continue
            }
            if (nums[m] > nums[h]) {
                m = h
                break
            }
            break
        }
        return nums[m]
    }
}
