class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        val map = hashMapOf<Char, Int>()

        s.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        t.forEach {
            val l = map.get(it)
            if (l == null) {
                return false
            }
            map[it] = l - 1
        }

        for (i in map.values) {
            if (i != 0) {
                return false
            }
        }
        return true
    }
}
