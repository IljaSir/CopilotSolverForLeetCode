class Solution {
    public int maxStarSum(int[] vals, int[][] edges, int k) {
        
        int n = vals.length;
        int[][] g = new int[n][n];
        for (int[] e : edges) {
            g[e[0]][e[1]] = g[e[1]][e[0]] = 1;
        }
        int[] dp = new int[n];
        int[] max = new int[n];
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i] = max[i] = vals[i];
            for (int j = 0; j < n; j++) {
                if (g[i][j] == 1) {
                    dp[i] += vals[j];
                    max[i] = Math.max(max[i], vals[j]);
                }
            }
            maxSum = Math.max(maxSum, dp[i]);
        }
        if (k == 0) {
            return maxSum;
        }
        int[][] dp2 = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                dp2[i][j] = dp[i];
                for (int m = 0; m < n; m++) {
                    if (g[i][m] == 1 && m != j) {
                        dp2[i][j] = Math.max(dp2[i][j], dp2[m][j - 1] + max[i]);
                    }
                }
                maxSum = Math.max(maxSum, dp2[i][j]);
            }
        }
        return maxSum;
    }
}