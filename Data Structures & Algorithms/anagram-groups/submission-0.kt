class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<HashMap<Char, Int>, MutableList<String>>()
        val list = mutableListOf<MutableList<String>>()

        strs.forEach { str ->
            val hm = hashMapOf<Char, Int>()
            str.forEach {
                hm[it] = hm.getOrDefault(it, 0) + 1
            }
            map.getOrPut(hm, ::mutableListOf).add(str)
        }
        return map.values.toList()
    }
}
