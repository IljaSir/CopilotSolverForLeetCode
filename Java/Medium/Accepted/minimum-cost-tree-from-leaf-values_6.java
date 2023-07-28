class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        int n = arr.length;
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            int m = arr[i];
            for (int j = i; j < n; j++) {
                m = Math.max(m, arr[j]);
                max[i][j] = m;
            }
        }
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + max[i][k] * max[k + 1][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}