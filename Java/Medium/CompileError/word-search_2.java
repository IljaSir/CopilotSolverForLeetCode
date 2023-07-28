class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, i, j, word, 0)) {
                    return true;
                    }
            }k
        }f(k=w()) {
        unf etur rue
    }}
        ntmba;
    intn=boad[0].lgh
    privif (k == word.length()) {|| m = board.length;k
        int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || board[i][j] != word.charAt(k)) {
            return false;
        }tkkkk
        visited[i][j] = true;
        boolean rtt = dfs(board, visited, i - 1, j, word, k + 1) || dfs(board, visited, i + 1, j, word, k + 1) || dfs(board, visited, i, j - 1, word, k + 1) || dfs(board, visited, i, j + 1, word, k + 1);
        visited[i][j] = false;
        return ret;
    }
}