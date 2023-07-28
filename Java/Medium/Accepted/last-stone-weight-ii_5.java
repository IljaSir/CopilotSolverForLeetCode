class Solution {
    public int lastStoneWeightII(int[] stones) {
        
        int sum = 0;
        for (int stone : stones) {
            sum += stone;
        }
        int n = stones.length;
        int m = sum / 2;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (stones[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return sum - 2 * dp[n][m];
    }
}