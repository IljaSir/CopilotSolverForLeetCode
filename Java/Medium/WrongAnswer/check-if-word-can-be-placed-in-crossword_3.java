class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        int m = board.length;
        int n = board[0].length;
        char[] w = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ' ' || board[i][j] == w[0]) {
                    if (j + w.length <= n && checkHorizontal(board, i, j, w)) {
                        return true;
                    }
                    if (i + w.length <= m && checkVertical(board, i, j, w)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean checkHorizontal(char[][] board, int i, int j, char[] w) {
        if (j > 0 && board[i][j - 1] != '#') {
            return false;
        }
        if (j + w.length < board[0].length && board[i][j + w.length] != '#') {
            return false;
        }
        for (int k = 0; k < w.length; k++) {
            if (board[i][j + k] != ' ' && board[i][j + k] != w[k]) {
                return false;
            }
        }
        return true;
    }
    
    private boolean checkVertical(char[][] board, int i, int j, char[] w) {
        if (i > 0 && board[i - 1][j] != '#') {
            return false;
        }
        if (i + w.length < board.length && board[i + w.length][j] != '#') {
            return false;
        }
        for (int k = 0; k < w.length; k++) {
            if (board[i + k][j] != ' ' && board[i + k][j] != w[k]) {
                return false;
            }
        }
        return true;
    }
}