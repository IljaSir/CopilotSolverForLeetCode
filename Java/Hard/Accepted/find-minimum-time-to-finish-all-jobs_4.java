class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int n = jobs.length;
        int[][] dp = new int[k][1 << n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < (1 << n); i++) {
            int total = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    total += jobs[j];
                }
            }
            dp[0][i] = total;
        }
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                for (int k2 = j; k2 > 0; k2 = (k2 - 1) & j) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][j - k2], dp[0][k2]));
                }
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
}