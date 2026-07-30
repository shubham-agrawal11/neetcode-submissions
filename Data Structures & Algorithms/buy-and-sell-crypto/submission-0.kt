class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0

        var min = prices[0]
        var max = prices[0]
        var profit = 0
        
        for (i in 1..prices.size - 1) {
            if (prices[i] < min) {
                min = prices[i]
                max = prices[i]
                continue
            }
            if (prices[i] > max) {
                max = prices[i]
            }
            profit = maxOf(profit, max - min)
        }
        return profit
    }
}
