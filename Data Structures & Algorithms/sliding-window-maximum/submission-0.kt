class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        // Maintaing max-heap
        var result = mutableListOf<Int>()
        var maxHeap = PriorityQueue<Int>(compareByDescending {it})
        var removeIndex = 0

        for (i in nums.indices) {
            maxHeap.add(nums[i])

            if (i >= k - 1) {
                result.add(maxHeap.peek()) // Add max element
                maxHeap.remove(nums[removeIndex]) // Remove starting element
                removeIndex++ // Increase starting element position
            }
        }
        return result.toIntArray()
    }
}
