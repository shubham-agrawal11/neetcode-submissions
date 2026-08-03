class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        // Deque
        var result = mutableListOf<Int>()
        var dq = ArrayDeque<Int>()
        var l = 0

        for (r in nums.indices) {
            // Remove all the smaller elements from deque
            while (dq.isNotEmpty() && nums[r] > nums[dq.last()]) {
                dq.removeLast()
            }

            // Add element to the last of deque
            dq.addLast(r)

            // if l is bigger that first element index,
            // that means it is no longer in window,
            // so remove it.
            if (l > dq.first()) {
                dq.removeFirst()
            }

            // if window reached, then add the biggest element
            // which is first element to the result.
            if (r + 1 >= k) {
                result.add(nums[dq.first()])
                l++
            }
        }
        
        return result.toIntArray()
    }
}
