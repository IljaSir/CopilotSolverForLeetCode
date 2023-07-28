class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) || board[i][j] == ' ') {
                    if (dfs(board, word, 0, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        
        if (visited[i][j]) {
            return false;
        }
        
        if (board[i][j] != word.charAt(index) && board[i][j] != ' ') {
            return false;
        }
        
        visited[i][j] = true;
        boolean isFound = dfs(board, word, index + 1, i + 1, j, visited) ||
                          dfs(board, word, index + 1, i - 1, j, visited) ||
                          dfs(board, word, index + 1, i, j + 1, visited) ||
                          dfs(board, word, index + 1, i, j - 1, visited);
        visited[i][j] = false;
        
        return isFound;
    }
}