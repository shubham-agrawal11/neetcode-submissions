class MinStack() {
    // Two stack
    var stack = ArrayDeque<Int>()
    var minStack = ArrayDeque<Int>()

    fun push(`val`: Int) {
        stack.addLast(`val`)
        val minVal = if (minStack.isNotEmpty()) {
            minOf(minStack.last(), `val`)
        } else {
            `val`
        }
        minStack.addLast(minVal)
    }

    fun pop() {
        stack.removeLast()
        minStack.removeLast()
    }

    fun top(): Int {
        return stack.last()
    }

    fun getMin(): Int {
        return minStack.last()
    }
}
