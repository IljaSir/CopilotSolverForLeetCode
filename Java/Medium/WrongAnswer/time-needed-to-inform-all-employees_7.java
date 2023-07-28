class Solution {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        
        int[] dp = new int[n];
        int res = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (i == headID) {
                continue;
            }
            dp[manager[i]] = Math.max(dp[manager[i]], informTime[manager[i]] + dp[i]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}