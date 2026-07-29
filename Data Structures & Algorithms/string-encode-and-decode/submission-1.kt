class Solution {
    // var list = MutableList<Pair<String, Int>>()
    // cannot use hashmap because string keys can be same

    fun encode(strs: List<String>): String {
        var encodedStr = ""
        strs.forEach {
            encodedStr += it.length.toString() + "#" + it
        }
        // encodedStr = encodedStr.dropLast(1)
        println(encodedStr)
        return encodedStr
    }

    fun decode(str: String): List<String> {
        var list = mutableListOf<String>()
        var len = ""
        var i = 0
        while (i < str.length) {
            if (str[i] != '#') {
                len += str[i]
                i++
                continue
            }
            // char is #
            var num = len.toInt()
            len = ""
            var word = str.substring(i+1, i+1+num)
            list.add(word)
            i = i + 1 + num
        }
        return list.toList()
    }
}
