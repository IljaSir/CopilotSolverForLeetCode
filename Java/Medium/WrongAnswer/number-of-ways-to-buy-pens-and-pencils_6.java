class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        int[] cost = {cost1, cost2};
        long[][] dp = new long[2][total + 1];
        for (int i = 0; i <= total; i++) {
            dp[0][i] = i % cost[0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < 2; i++) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= cost[i]) {
                    dp[i][j] += dp[i][j - cost[i]];
                }
            }
        }
        return dp[1][total];
    }
}