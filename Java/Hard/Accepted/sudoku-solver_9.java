class Solution {
    public void solveSudoku(char[][] board) {
        
        backtrack(board, 0, 0);
    }
    private boolean backtrack(char[][] board, int i, int j) {
        if (j == 9) return backtrack(board, i + 1, 0);
        if (i == 9) return true;
        if (board[i][j] != '.') return backtrack(board, i, j + 1);
        else {
            for (char c = '1'; c <= '9'; c++) {
                if (!isValid(board, i, j, c)) continue;
                board[i][j] = c;
                if (backtrack(board, i, j + 1)) return true;
                board[i][j] = '.';
            }
            return false;
        }
    }
    private boolean isValid(char[][] board, int i, int j, char c) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == c) return false;
            if (board[k][j] == c) return false;
            if (board[3 * (i / 3) + k / 3][3 * (j / 3) + k % 3] == c) return false;
        }
        return true;
    }
}