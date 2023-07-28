class Solution {
    public void gameOfLife(int[][] board) {
        
        int m = board.length;
        int n = board[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = countNeighbors(board, i, j, m, n);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        result[i][j] = 0;
                    } else {
                        result[i][j] = 1;
                    }
                } else {
                    if (count == 3) {
                        result[i][j] = 1;
                    } else {
                        result[i][j] = 0;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = result[i][j];
            }
        }
    }
    public int countNeighbors(int[][] board, int i, int j, int m, int n) {
        int count = 0;
        if (i - 1 >= 0 && j - 1 >= 0 && board[i - 1][j - 1] == 1) {
            count++;
        }
        if (i - 1 >= 0 && board[i - 1][j] == 1) {
            count++;
        }
        if (i - 1 >= 0 && j + 1 < n && board[i - 1][j + 1] == 1) {
            count++;
        }
        if (j - 1 >= 0 && board[i][j - 1] == 1) {
            count++;
        }
        if (j + 1 < n && board[i][j + 1] == 1) {
            count++;
        }
        if (i + 1 < m && j - 1 >= 0 && board[i + 1][j - 1] == 1) {
            count++;
        }
        if (i + 1 < m && board[i + 1][j] == 1) {
            count++;
        }
        if (i + 1 < m && j + 1
    }
}