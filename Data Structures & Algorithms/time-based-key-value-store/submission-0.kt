class TimeMap() {
    val map = hashMapOf<String, MutableList<Pair<String, Int>>>()

    fun set(key: String, value: String, timestamp: Int) {
        if (!map.containsKey(key)) {
            map[key] = mutableListOf()
        }
        map[key]!!.add(Pair(value, timestamp))
    }

    fun get(key: String, timestamp: Int): String {
        var res = ""
        var values = map[key] ?: return res

        var l = 0
        var r = values.size - 1

        while (l <= r) {
            var m = (l+r) / 2
            if (values[m].second <= timestamp) {
                res = values[m].first
                l = m + 1
            } else {
                r = m - 1
            }
        }
        return res
    }
}
