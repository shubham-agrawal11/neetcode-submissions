class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        // Slding window with 2 pointers
        val map = hashMapOf<Char, Int>() // count of char with their frequency
        var l = 0
        var result = 0
        var maxF = 0 // max frequency out of all the chars

        for (r in s.indices) {
            map[s[r]] = map.getOrDefault(s[r], 0) + 1
            maxF = maxOf(maxF, map[s[r]]!!)

            val changeRequired = (r - l + 1) - maxF
            if (changeRequired > k) {
                map[s[l]] = map.getOrDefault(s[l], 0) - 1
                l++
            }
            result = maxOf(result, r-l+1)
        }
        return result
    }
}
