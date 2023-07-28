class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[m+1][1 << n];
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < (1 << n); j++) {
                if (valid(seats, i-1, j)) {
                    for (int k = 0; k < (1 << n); k++) {
                        if (valid(seats, i-2, k)) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + count(j));
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            res = Math.max(res, dp[m][i]);
        }
        return res;
    }
    public boolean valid(char[][] seats, int i, int j) {
        int n = seats[0].length;
        for (int k = 0; k < n; k++) {
            if ((j & (1 << k)) != 0) {
                if (i >= 0 && seats[i][k] == '#') {
                    return false;
                }
                if (k > 0 && (j & (1 << (k-1))) != 0) {
                    return false;
                }
                if (k < n-1 && (j & (1 << (k+1))) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public int count(int j) {
        int res = 0;
        while (j > 0) {
            res += j & 1;
            j >>= 1;
        }
        return res;
    }
}