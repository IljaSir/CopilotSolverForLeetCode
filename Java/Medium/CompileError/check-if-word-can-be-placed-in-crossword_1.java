class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == ' ' || board[i][j] == word.charAt(0)) {
                    if (check(board, i, j, word, 0, 0)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean check(char[][] board, int i, int j, String word, int pos, int dir) {
        if (pos == word.length()) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return false;
        }
        if (board[i][j] == '#') {
            return false;
        }
        if (board[i][j] != ' ' && board[i][j] != word.charAt(pos)) {
            return false;
        }
        if (dir == 0) {
            if (j > 0 && board[i][j - 1] != '#') {
                return false;
            }
            if (j < board[i].length - 1 && board[i][j + 1] != '#') {
                return false;
            }
        }
        if (dir == 1) {
            if (i > 0 && board[i - 1][j] != '#') {
                return false;
            }
            if (i < board.length - 1 && board[i + 1][j] != '#') {
                return false;
            }
        }
        if (dir == 2) {
            if (j > 0 && board[i][j - 1] != '#') {
                return false;
            }
            if (j < board[i].length - 1 && board[i][j + 1] != '#') {
                return false;
            }
        }
        if (dir == 3) {
            if (i > 0 && board[i - 1][j] != '#') {
                return false;
            }
            if (i < board.length - 1 && board[i + 1][j] != '#') {
                return false;
            }
        }
        if (dir == 0) {
            if (check(board,
    }
}