class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int n = board[i][j] - '1';
                    if (row[i][n] || col[j][n] || box[i / 3][j / 3][n]) {
                        return false;
                    }
                    row[i][n] = true;
                    col[j][n] = true;
                    box[i / 3][j / 3][n] = true;
                }
            }
        }
        return true;
    }
}