class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        // Sliding window
        val map = hashMapOf<Char, Int>()
        var max = 0
        var start = 0

        for (i in s.indices) {
            val charIndex = map.getOrDefault(s[i], -1)
            if (charIndex != -1) {
                // Char already exists
                start = maxOf(start, charIndex + 1)
            }
            map[s[i]] = i
            max = maxOf(max, i - start + 1)
        }
        return max
    }
}
