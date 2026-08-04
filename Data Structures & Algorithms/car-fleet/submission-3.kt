class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val pair = position.zip(speed).sortedByDescending { it.first }

        var noOfFleets = 0
        var prevTime: Double = Double.MIN_VALUE
        for (i in pair.indices) {
            var (position, speed) = pair[i]
            val hours = (target - position).toDouble()/speed

            if (hours > prevTime) {
                noOfFleets++
                prevTime = hours
            }

        }
        return noOfFleets
    }
}
