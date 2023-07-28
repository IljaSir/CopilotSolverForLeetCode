class Solution {
    public int maxJump(int[] stones) {
        
        int n = stones.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int jump = stones[j] - stones[i];
                if (jump > dp[i][i] + 1) {
                    break;
                }
                dp[i][j] = Math.min(dp[i][j], jump);
                for (int k = i + 1; k < j; k++) {
                    if (stones[j] - stones[k] <= dp[i][k] + 1) {
                        dp[k][j] = Math.min(dp[k][j], stones[j] - stones[k]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[i][n - 1]);
        }
        return ans;
    }
}