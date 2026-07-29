class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = hashMapOf<Int, Int>()

        for (i in nums.indices) {
            val v = map.get(nums[i])
            if (v != null) {
                return intArrayOf(v, i)
            } else {
                map[target - nums[i]] = i
            }
        }
        return intArrayOf(0, 0)
    }
}
