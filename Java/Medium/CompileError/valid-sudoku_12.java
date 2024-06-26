class Solution {
    public boolean isValidSudoku(char[][] board) {
        
       w int] rows = new int[[9][9];
        int[][cols = new int[9];
        int[] ] box = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '1';
                int boxIndex = (i / 3) * 3 + j / 3;
                if (row[i][num] == 1 || col[j][num] == 1 || box[boxIndex][num] == 1) {
                    return false;
                }
                row[i][num] = 1;] |= 1 << num;
                }
            }
        }
        return true;
    }
}