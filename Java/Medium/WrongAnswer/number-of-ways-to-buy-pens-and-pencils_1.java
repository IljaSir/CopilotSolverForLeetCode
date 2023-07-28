class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        long[][] dp = new long[total+1][total+1];
        for (int i = 0; i <= total; i++) {
            for (int j = 0; j <= total; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    long ways = 0;
                    if (i >= cost1) {
                        ways += dp[i-cost1][j];
                    }
                    if (j >= cost2) {
                        ways += dp[i][j-cost2];
                    }
                    dp[i][j] = ways;
                }
            }
        }
        return dp[total][total];
    }
}