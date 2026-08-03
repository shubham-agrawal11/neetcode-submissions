class Solution {
    fun isValid(s: String): Boolean {
        var stack = ArrayDeque<Char>()
        val map = hashMapOf<Char, Char>(
            '(' to ')',
            '[' to ']',
            '{' to '}'
        )

        for (c in s) {
            if (map.containsKey(c)) {
                // c is opening bracket
                stack.addFirst(c)
            } else {
                // c is closing bracket
                if (stack.isEmpty()) {
                    return false
                }
                var last = stack.removeFirst()
                if (map[last] != c) return false
            }
        }
        return stack.isEmpty()
    }
}
