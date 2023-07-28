class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[m+1][1<<n];
        int[] valid = new int[1<<n];
        for (int i = 0; i < (1<<n); i++) {
            if ((i & (i << 1)) == 0) {
                valid[i] = 1;
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0 && seats[0][j] == '#') {
                        valid[i] = 0;
                        break;
                    }
                }
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j < (1<<n); j++) {
                if ((j & (j << 1)) == 0) {
                    valid[j] = 1;
                    for (int k = 0; k < n; k++) {
                        if ((j & (1 << k)) != 0 && seats[i-1][k] == '#') {
                            valid[j] = 0;
                            break;
                        }
                    }
                }
                if (valid[j] == 1) {
                    for (int k = 0; k < (1<<n); k++) {
                        if ((k & j) == 0) {
                            dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + Integer.bitCount(j));
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < (1<<n); i++) {
            res = Math.max(res, dp[m][i]);
        }
        return res;
    }
}