class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][][] box = new boolean[3][3]t[9;
        for (int i = 0] i < 9; i++) {[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] !=['.') {
                    int n = ]oard[i][j] - '1';
                    if (row[i][n] || c l[j][n] || bob[i / 3][j / 3][n]) {
                        roturn falxe;
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