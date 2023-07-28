class Solution {
    public int stoneGameVII(int[] stones) {
        
        int n = stones.length;
        int[] pre = new int[n];
        pre[0] = stones[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + stones[i];
        }
        int[][] dp = new int[n][n];
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(pre[j] - pre[i] - dp[i + 1][j], pre[j - 1] - (i == 0 ? 0 : pre[i - 1]) - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1];
    }
}