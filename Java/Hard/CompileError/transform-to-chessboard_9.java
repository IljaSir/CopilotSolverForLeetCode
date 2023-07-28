class Solution {
    public int movesToChessboard(int[][] board) {
        
        int n = board.length;
        int[][] board1 = new int[n][n];
        int[][] board2 = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board1[i][j] = (i + j) % 2;
                board2[i][j] = (i + j + 1) % 2;
            }
        }
        int count1 = 0;
        int count2 = 0;
        int count3 = 0;
        int count4 = 0;
        int count5 = 0;
        int count6 = 0;
        int count7 = 0;
        int count8 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != board1[i][j]) {
                    count1++;
                }
                if (board[i][j] != board2[i][j]) {
                    count2++;
                }
                if (board[j][i] != board1[j][i]) {
                    count3++;
                }
                if (board[j][i] != board2[j][i]) {
                    count4++;
                }
                if (board[i][j] != board1[j][i]) {
                    count5++;
                }
                if (board[i][j] != board2[j][i]) {
                    count6++;
                }
                if (board[j][i] != board1[i][j]) {
                    count7++;
                }
                if (board[j][i] != board2[i][j]) {
                    count8++;
                }
            }
        }
        if (count1 % 2 == 1 || count2 % 2 == 1 || count3 % 2 == 1 || count4 % 2 == 1 || count5 % 2 == 1 || count6 % 2 == 1 || count7 % 2 == 1 || count8 % 2 == 1) {
            return -1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n;
    }
}