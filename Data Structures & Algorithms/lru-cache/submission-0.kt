class LRUCache(capacity: Int) {

    private class Node(
        val key: Int,
        var value: Int,
        var prev: Node? = null,
        var next : Node? = null
    )
    private val capacity = capacity

    private val cache = HashMap<Int, Node>()
    private val left = Node(0, 0)
    private val right = Node(0, 0)

    init {
        left.next = right
        right.prev = left
    }

    private fun remove(node: Node) {
        val prev = node.prev
        val next = node.next
        prev?.next = next
        next?.prev = prev
    }

    private fun insert(node: Node) {
        val prev = right.prev
        right.prev = node
        prev?.next = node
        node.prev = prev
        node.next = right
    }

    fun get(key: Int): Int {
        return cache[key]?.let { node ->
            remove(node)
            insert(node)
            node.value
        } ?: -1
    }

    fun put(key: Int, value: Int) {
        cache[key]?.let { node ->
            remove(node)
            cache.remove(key)
        }

        val node = Node(key, value)
        cache[key] = node
        insert(node)

        if (cache.size > capacity) {
            left.next?.let { lru ->
                remove(lru)
                cache.remove(lru.key)
            }
        }
    }
}
