class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        var stack = ArrayDeque<Int>()

        var one = 0
        var two = 0
        for (t in tokens) {
            if (t.toIntOrNull() != null) {
                stack.addLast(t.toInt())
                continue
            }
            // t is not digit, it means it is an operator
            val second = stack.removeLast()
            var first = stack.removeLast()
            stack.addLast(calc(first, second, t))
        }
        return stack.last()
    }

    fun calc(one: Int, two: Int, operator: String): Int {
        return when (operator) {
            "+" -> one + two
            "-" -> one - two
            "*" -> one * two
            else -> one / two
        }
    }
}
