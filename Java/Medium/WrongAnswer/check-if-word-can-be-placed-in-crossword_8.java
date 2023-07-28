class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        int len = word.length();
        // check row wise
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n - len; j++) {
                if (checkRow(board, i, j, word)) {
                    return true;
                }
            }
        }
        // check column wise
        for (int j = 0; j < n; j++) {
            for (int i = 0; i <= m - len; i++) {
                if (checkColumn(board, i, j, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean checkRow(char[][] board, int i, int j, String word) {
        int len = word.length();
        if (j > 0 && board[i][j - 1] != '#') {
            return false;
        }
        if (j + len < board[0].length && board[i][j + len] != '#') {
            return false;
        }
        for (int k = 0; k < len; k++) {
            if (board[i][j + k] == '#') {
                return false;
            }
            if (board[i][j + k] != ' ' && board[i][j + k] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkColumn(char[][] board, int i, int j, String word) {
        int len = word.length();
        if (i > 0 && board[i - 1][j] != '#') {
            return false;
        }
        if (i + len < board.length && board[i + len][j] != '#') {
            return false;
        }
        for (int k = 0; k < len; k++) {
            if (board[i + k][j] == '#') {
                return false;
            }
            if (board[i + k][j] != ' ' && board[i + k][j] != word.charAt(k)) {
                return false;
            }
        }
        return true;
    }
}