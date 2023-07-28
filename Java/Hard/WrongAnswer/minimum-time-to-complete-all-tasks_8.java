class Solution {
    public int findMinimumTime(int[][] tasks) {
        
        int n = tasks.length;
        int[] dp = new int[2001];
        for (int i = 0; i < n; ++i) {
            for (int j = tasks[i][0]; j <= tasks[i][1]; ++j) {
                dp[j] = Math.max(dp[j], tasks[i][2]);
            }
        }
        int ans = 0;
        for (int i = 1; i <= 2000; ++i) {
            ans += dp[i];
        }
        return ans;
    }
}