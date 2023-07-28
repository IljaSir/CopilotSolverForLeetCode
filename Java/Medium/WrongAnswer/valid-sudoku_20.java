class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        boolean[] row = new boolean[9];
        boolean[] col = new boolean[9];
        boolean[] box = new boolean[9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int boxIndex = (i / 3) * 3 + j / 3;
                    if (row[i] || col[j] || box[boxIndex]) {
                        return false;
                    }
                    row[i] = true;
                    col[j] = true;
                    box[boxIndex] = true;
                }
            }
        }
        return true;
    }
}