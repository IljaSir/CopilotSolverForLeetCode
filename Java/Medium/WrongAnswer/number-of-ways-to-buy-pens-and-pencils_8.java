class Solution {
    public long waysToBuyPensPencils(int total, int cost1, int cost2) {
        
        final int max = 1000000;
        long[][] dp = new long[max+1][2];
        for (int i = 1; i <= max; i++) {
            int p = i - cost1;
            if (p >= 0) {
                dp[i][0] = dp[p][0] + dp[p][1] + 1;
            }
            int q = i - cost2;
            if (q >= 0) {
                dp[i][1] = dp[q][0] + dp[q][1] + 1;
            }
        }
        long ans = 0;
        for (int i = 0; i <= total; i++) {
            ans += dp[i][0] + dp[i][1];
        }
        return ans;
    }
}