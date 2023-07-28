class Solution {
    public int stoneGameVII(int[] stones) {
        
        int n = stones.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                int j = i + len - 1;
                dp[i][j] = Math.max(prefix[j + 1] - prefix[i + 1] - dp[i + 1][j], prefix[j] - prefix[i] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}