class Solution {
    fun hasDuplicate(nums: IntArray): Boolean {
        val map = hashMapOf<Int, Int>()

        for (i in nums) {
            if (map.keys.contains(i) != false) {
                return true
            }
            map[i] = map.getOrDefault(i, 0) + 1
        }
        return false
    }
}
