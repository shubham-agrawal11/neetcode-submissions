class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        // Creating map
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        var arr = Array(nums.size + 1) { mutableListOf<Int>() }
        for ((num, count) in map) {
            arr[count].add(num)
        }

        var result = mutableListOf<Int>()
        for (i in arr.size - 1 downTo 0) {
            for (j in arr[i]) {
                result.add(j)
                if (result.size == k) {
                    return result.toIntArray()
                }
            }
        }
        return result.toIntArray()
    }
}
