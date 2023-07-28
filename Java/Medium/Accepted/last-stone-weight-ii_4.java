class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        int n = stones.length, m = sum / 2;
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - stones[i - 1]];
                }
            }
        }
        for (int j = m;; j--) {
            if (dp[n][j]) {
                return sum - 2 * j;
            }
        }
    }
}