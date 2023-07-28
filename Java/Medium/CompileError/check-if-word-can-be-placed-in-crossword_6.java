class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    boolean res = dfs(board, word, i, j, 0, visited);
                    if (res) return true;
                }
            }
        }
        return false;
    }
}