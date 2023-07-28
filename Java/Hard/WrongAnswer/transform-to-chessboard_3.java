class Solution {
    public int movesToChessboard(int[][] board) {
        
        int n = board.length;
        int[] row = new int[n];
        int[] col = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                row[i] = (row[i] << 1) | board[i][j];
                col[j] = (col[j] << 1) | board[i][j];
            }
        }
        return check(row, n) && check(col, n) ? Math.max(count(row[0]), count(row[n - 1])) : -1;
    }

    private boolean check(int[] row, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += row[i];
        }
        int target = n / 2;
        if (n % 2 == 0) {
            if (sum != target * n && sum != (target + 1) * n) return false;
            for (int i = 0; i < n; i++) {
                if (row[i] == row[0]) continue;
                if (i % 2 == 0) {
                    if (row[i] != row[0] + 1) return false;
                } else {
                    if (row[i] != row[0] - 1) return false;
                }
            }
        } else {
            if (sum != target * (n - 1) + n) return false;
            for (int i = 0; i < n; i++) {
                if (row[i] == row[0]) continue;
                if (i % 2 == 0) {
                    if (row[i] != row[0] - 1) return false;
                } else {
                    if (row[i] != row[0] + 1) return false;
                }
            }
        }
        return true;
    }

    private int count(int num) {
        int res = 0;
        while (num > 0) {
            res += num & 1;
            num >>= 1;
        }
        return res;
    }
}