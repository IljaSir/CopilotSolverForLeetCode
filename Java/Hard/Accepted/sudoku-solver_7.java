class Solution {
    public void solveSudoku(char[][] board) {
        
        solve(board, 0, 0);
    }
    public boolean solve(char[][] board, int i, int j) {
        if (i == 9) {
            return true;
        }
        if (j == 9) {
            return solve(board, i + 1, 0);
        }
        if (board[i][j] != '.') {
            return solve(board, i, j + 1);
        }
        for (char ch = '1'; ch <= '9'; ch++) {
            if (isValid(board, i, j, ch)) {
                board[i][j] = ch;
                if (solve(board, i, j + 1)) {
                    return true;
                }
                board[i][j] = '.';
            }
        }
        return false;
    }
    public boolean isValid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == ch) {
                return false;
            }
            if (board[k][j] == ch) {
                return false;
            }
            if (board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == ch) {
                return false;
            }
        }
        return true;
    }
}