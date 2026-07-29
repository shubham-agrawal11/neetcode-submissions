class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }

        // var maxHeap = PriorityQueue<HashMap<Int, Int>>{ map1, map2 ->
        //     val weight1 = map1[0] ?: 0
        //     val weight2 = map2[1] ?: 0
        //     weight2.compareTo(weight1) // Reverse order for Max-Heap
        // }
        val maxHeap = PriorityQueue<Int> { a, b -> map[b]!! - map[a]!! }
        
        for (key in map.keys) {
            maxHeap.add(key)
        }
        // maxHeap.add(map)
        println("maxHeap = $maxHeap")

        var arr = IntArray(k)
        // val x = maxHeap.poll().keys
        for (i in 0 until k) {
            arr[i] = maxHeap.poll()
        }
        return arr
    }
}
