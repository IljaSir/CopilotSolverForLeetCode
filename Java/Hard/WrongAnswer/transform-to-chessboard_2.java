class Solution {
    public int movesToChessboard(int[][] board) {
        
        int n = board.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = (row[i] << 1) + board[i][j];
                col[j] = (col[j] << 1) + board[i][j];
            }
        }
        int r1 = 0, r2 = 0, c1 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if (row[0] != row[i]) {
                r1++;
            }
            if (col[0] != col[i]) {
                c1++;
            }
            if (row[0] != row[i] ^ (i % 2 == 0)) {
                r2++;
            }
            if (col[0] != col[i] ^ (i % 2 == 0)) {
                c2++;
            }
        }
        if (r1 != c1 || r1 != 0 && r1 != n - 1 || r2 != c2 || r2 != 0 && r2 != n - 1) {
            return -1;
        }
        if (n % 2 == 1) {
            if (r1 % 2 == 1) {
                r1 = n - r1;
            }
            if (r2 % 2 == 1) {
                r2 = n - r2;
            }
        } else {
            r1 = Math.min(n - r1, r1);
            r2 = Math.min(n - r2, r2);
        }
        return (r1 + r2) / 2;
    }
}