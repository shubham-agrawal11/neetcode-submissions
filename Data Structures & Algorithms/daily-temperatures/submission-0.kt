class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        // Simple stack
        if (temperatures.isEmpty()) return intArrayOf()

        val stack = ArrayDeque<Int>() // Stack of index
        var result = IntArray(temperatures.size) {0}

        for (i in temperatures.indices) {
            while (stack.isNotEmpty() && 
                temperatures[i] > temperatures[stack.last()]
            ) {
                result[stack.last()] = i - stack.last() 
                stack.removeLast()
            }
            stack.addLast(i)
        }
        return result
    }
}
