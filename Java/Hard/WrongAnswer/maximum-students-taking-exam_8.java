class Solution {
    public int maxStudents(char[][] seats) {
        
        int m = seats.length;
        int n = seats[0].length;
        int[][] dp = new int[2][1 << n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < (1 << n); k++) {
                    if (((k >> j) & 1) == 1) {
                        if (seats[i][j] == '#' || (j > 0 && ((k >> (j - 1)) & 1) == 1) || (j < n - 1 && ((k >> (j + 1)) & 1) == 1)) {
                            dp[i % 2][k] = 0;
                        } else {
                            dp[i % 2][k] = Integer.bitCount(k);
                            if (i > 0) {
                                dp[i % 2][k] += Math.max(dp[(i - 1) % 2][k], Math.max(dp[(i - 1) % 2][k & ~(1 << j)], j > 0 ? dp[(i - 1) % 2][k & ~(1 << (j - 1))] : 0));
                            }
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < (1 << n); i++) {
            res = Math.max(res, dp[(m - 1) % 2][i]);
        }
        return res;
    }
}