/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(a: List<Interval>): Boolean {
        // sort
        val intervals = a.toMutableList()
        intervals.sortBy { it.start }
        var canAttend = true
    
        for (i in intervals.indices) {
            println(intervals[i].start.toString())
            if (intervals[i].end > (intervals.getOrNull(i+1)?.start ?: Int.MAX_VALUE)) {
                return false
            }
        }
        return canAttend
    }
}
