class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        int[] row = new int[9];
        int[] col = new int[9];
        int[][] block = new int[3][3];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '0';
                int k = i / 3, l = j / 3;
                if ((row[i] >> num & 1) == 1) return false;
                if ((col[j] >> num & 1) == 1) return false;
                if ((block[k][l] >> num & 1) == 1) return false;
                row[i] |= 1 << num;
                col[j
                block[k][l] |= 1 << num;
            }
        }
        return true;
    }
}