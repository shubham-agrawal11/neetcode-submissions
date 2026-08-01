class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        // Sliding window
        if (s1.length > s2.length) return false
        val arr1 = IntArray(26)
        var arr2 = IntArray(26)

        for (i in s1.indices) {
            arr1[s1[i] - 'a']++
            arr2[s2[i] - 'a']++
        }

        var l = 0
        for (r in 0 until s2.length - s1.length) {
            if (arr1.contentEquals(arr2)) return true

            arr2[s2[r] - 'a']--
            arr2[s2[r + s1.length] - 'a']++
        }

        return arr1.contentEquals(arr2)
    }
}
