class Solution {
    public int mctFromLeafValues(int[] arr) {
        
        int n = arr.length;
        int[][] dp = new int[n][n];
        int[][] max = new int[n][n];
        for (int i = 0; i < n; i++) {
            max[i][i] = arr[i];
            for (int j = i + 1; j < n; j++) {
                max[i][j] = Math.max(max[i][j - 1], arr[j]);
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j + i < n; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++) {
                    dp[j][j + i] = Math.min(dp[j][j + i], dp[j][k] + dp[k + 1][j + i] + max[j][k] * max[k + 1][j + i]);
                }
            }
        }
        return dp[0][n - 1];
    }
}