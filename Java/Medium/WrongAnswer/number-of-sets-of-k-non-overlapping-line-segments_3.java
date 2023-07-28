class Solution {
    public int numberOfSets(int n, int k) {
        
        int mod = 1000000007;
        long[][] dp = new long[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int) dfs(n - 1, k, dp);
    }
    private long dfs(int n, int k, long[][] dp) {
        if (k == 0) {
            return 1;
        }
        if (n < 2 * k - 1) {
            return 0;
        }
        if (dp[n][k] != -1) {
            return dp[n][k];
        }
        long res = (dfs(n - 1, k, dp) + dfs(n - 1, k - 1, dp)) % 1000000007;
        res = (res + (n - 1) * dfs(n - 2, k - 1, dp)) % 1000000007;
        dp[n][k] = res;
        return res;
    }
}