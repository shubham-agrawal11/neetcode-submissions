class Solution {
    fun trap(height: IntArray): Int {
        // Two pointers approach
        if (height.size < 3) return 0 // just 2 height cannot make a container

        var l = 0
        var r = height.size - 1
        var leftMax = height[l]
        var rightMax = height[r]
        var result = 0

        while (l < r) {
            if (leftMax < rightMax) {
                l++
                leftMax = maxOf(leftMax, height[l])
                result += leftMax - height[l]
            } else {
                r--
                rightMax = maxOf(rightMax, height[r])
                result += rightMax - height[r]
            }
        }
        return result
    }
}
