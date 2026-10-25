class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var map = hashMapOf<Int, Int>()
        for (num in nums) {
            if (map.containsKey(num)) {
                return num
            }
            map[num] = 1
        }
        return -1
    }
}
