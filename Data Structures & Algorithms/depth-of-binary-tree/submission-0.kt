/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        // BFS - Using queue
        if (root == null) return 0

        var depth = 0
        var q = ArrayDeque<TreeNode>()
        q.addLast(root)

        while (q.isNotEmpty()) {
            var size = q.size
            
            // // To ensure depth is increased only once for each level
            repeat(size) {
                var node = q.removeFirst()
                
                node.left?.let { q.addLast(it) }
                node.right?.let { q.addLast(it) }
            }
            depth++
        }
        return depth
    }
}
