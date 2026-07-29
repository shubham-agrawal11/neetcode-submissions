class Solution {
    fun encode(strs: List<String>): String {
        var encodedStr = StringBuilder()
        strs.forEach {
            encodedStr
                .append(it.length)
                .append("#")
                .append(it)
        }
        return encodedStr.toString()
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
        return list
    }
}
