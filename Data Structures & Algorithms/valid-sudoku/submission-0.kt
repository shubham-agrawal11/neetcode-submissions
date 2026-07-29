class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { HashSet<Char>() }
        val cols = Array(9) { HashSet<Char>() }
        val squares = Array(9) { HashSet<Char>() }

        for (i in board.indices) {
            for (j in board[0].indices) {
                val c = board[i][j]
                if (c == '.') continue

                val squareId = (i/3) * 3 + (j/3) // (row/3) * boxGridSize + (column/3)
                if (rows[i].contains(c) 
                || cols[j].contains(c) 
                || squares[squareId].contains(c)
                ) {
                    return false
                }

                rows[i].add(c)
                cols[j].add(c)
                squares[squareId].add(c)
            }
        }
        return true
    }
}
