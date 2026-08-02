class Solution {
    fun minWindow(s: String, t: String): String {
        // Sliding window
        if (t.isEmpty()) return ""
        if (t.length > s.length) return ""

        val tmap = hashMapOf<Char, Int>()

        for (c in t) {
            tmap[c] = tmap.getOrDefault(c, 0) + 1
        }

        var have = 0
        var need = tmap.size
        var l = 0
        var res = IntArray(2) {-1}
        var result = Int.MAX_VALUE
        val smap = hashMapOf<Char, Int>()

        for (r in s.indices) {
            val c = s[r]
            smap[c] = smap.getOrDefault(c, 0) + 1

            if (tmap.contains(c) && smap[c] == tmap[c]) {
                have++
            }
            
            while (have == need) {
                // when found smaller substring result
                if (r-l+1 < result) {
                    res[0] = l
                    res[1] = r
                    result = r-l+1
                }

                smap[s[l]] = smap.getOrDefault(s[l], 0) - 1

                // After removing s[l], check if it belongs to result then reduce 'have'
                if (tmap.contains(s[l]) && (smap[s[l]] ?: 0) < tmap[s[l]]!!) {
                    have--
                }
                l++
            }
        }

        return if (res[0] == -1) "" 
        else s.substring(res[0], res[1] + 1)
    }
}
