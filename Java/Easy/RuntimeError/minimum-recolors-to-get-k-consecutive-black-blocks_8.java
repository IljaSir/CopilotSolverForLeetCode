class Solution {
    public int minimumRecolors(String blocks, int k) {
        
        int n = blocks.length();
        int[] dp = new int[n + 1];
        int[] sum = new int[n + 1];
        int[][] f = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + (blocks.charAt(i - 1) == 'B' ? 1 : 0);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = f[i - 1][j] + (blocks.charAt(i - 1) == 'W' && j <= k ? 1 : 0);
            }
        }
        for (int i = 1; i <= n; i++) {
            dp[i] = f[i][k];
            for (int j = 1; j < i; j++) {
                dp[i] = Math.min(dp[i], dp[j] + f[i][k] - f[j + k][k]);
            }
        }
        return dp[n];
    }
}