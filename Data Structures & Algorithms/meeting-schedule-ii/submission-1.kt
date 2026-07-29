/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        val list = intervals.toMutableList()
        list.sortBy { it.start }

        if (list.isEmpty()) return 0

        val minHeap = PriorityQueue<Int>()

        minHeap.add(list[0].end) // Adding first element

        for (i in 1..list.size - 1) {
            if (minHeap.peek() <= list[i].start) {
                minHeap.poll()
            }
            minHeap.add(list[i].end)
        }
        return minHeap.size
    }
}
