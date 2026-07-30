class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0

        var hSet = hashSetOf<Char>()
        for (i in 0.. s.length - 1) {
            if (i >= s.length - max) {
                break
            }
            
            var tempMax = 0
            var index = i
            while (index <= s.length - 1) {
                if (!hSet.contains(s[index])) {
                    hSet.add(s[index])
                    index++
                    tempMax++
                } else {
                    break
                }
            }
            hSet.clear()
            max = maxOf(max, tempMax)
        }
        return max
    }
}
