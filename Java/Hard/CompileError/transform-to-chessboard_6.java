class Solution {
    public int movesToChessboard(int[][] board) {
        
        int n = board.length;
        int[][] expected = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i + j) % 2 == 0) {
                    expected[i][j] = 1;
                }
            }
        }
        int[] rowDiff = new int[n];
        int[] colDiff = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != expected[i][j]) {
                    rowDiff[i]++;
                }
                if (board[j][i] != expected[j][i]) {
                    colDiff[i]++;
                }
            }
        }
        int rowSwap = check(rowDiff);
        int colSwap = check(colDiff);
        if (rowSwap == -1 || colSwap == -1) {
            return -1;
        }
        return (rowSwap + colSwap) / 2;
    }

    private int check(int[] diff) {
        int n = diff.length;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < n; i++) {
            if (diff[i] % 2 == 1) {
                count1++;
            } else {
                count2++;
            }
        }
        if (n % 2 == 0) {
            if (count1 != count2 || count1 != n / 2 || count2 != n / 2) {
                return -1;
            }
        } else {
            if (count1 != count2 || count1 != n / 2 + 1 || count2 != n / 2) {
                return -1;
            }
        }
        int rowSwap1 = 0;
        int rowSwap2 = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                rowSwap1 += diff[i] / 2;
                rowSwap2 += (diff[i] + 1) / 2;
            } else {
                rowSwap1 += (diff[i] + 1) / 2;
    }
}