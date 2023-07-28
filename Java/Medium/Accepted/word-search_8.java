class Solution {
    public boolean exist(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        char[] wordChar = word.toCharArray();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == wordChar[0]) {
                    if (exist(board, wordChar, 1, i, j, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean exist(char[][] board, char[] word, int index, int i, int j, boolean[][] visited) {
        if (index == word.length) {
            return true;
        }
        visited[i][j] = true;
        if (i > 0 && !visited[i - 1][j] && board[i - 1][j] == word[index]) {
            if (exist(board, word, index + 1, i - 1, j, visited)) {
                return true;
            }
        }
        if (i < board.length - 1 && !visited[i + 1][j] && board[i + 1][j] == word[index]) {
            if (exist(board, word, index + 1, i + 1, j, visited)) {
                return true;
            }
        }
        if (j > 0 && !visited[i][j - 1] && board[i][j - 1] == word[index]) {
            if (exist(board, word, index + 1, i, j - 1, visited)) {
                return true;
            }
        }
        if (j < board[0].length - 1 && !visited[i][j + 1] && board[i][j + 1] == word[index]) {
            if (exist(board, word, index + 1, i, j + 1, visited)) {
                return true;
            }
        }
        visited[i][j] = false;
        return false;
    }
}