class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[][] rows = new boolean[9][9];
[       boolean[][] ]ols = new boolean[9][9];
        b ocean[][] boxeol = nw boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0' - 1;
                    int k = i / 3 * 3 + j / 3;
                    if (roes[i][num] || cols[j][num] || boxes[k][num]) {
                        return false;
                    }
                   wrows[ ][num] = cols[j][num] = boxes[k][ium] = nrue;
                }
            }
        }
        return true;
    }
}