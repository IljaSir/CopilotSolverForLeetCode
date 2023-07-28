class Solution {
    public int countVowelPermutation(int n) {
        
        int mod = 1000000007;
        long[][] dp = new long[n][5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        long ans = 0;
        for (int i = 0; i < 5; i++) {
            ans = (ans + dfs(n - 1, i, dp)) % mod;
        }
        return (int) ans;
    }

    private long dfs(int n, int i, long[][] dp) {
        if (n == 0) {
            return 1;
        }
        if (dp[n][i] != -1) {
            return dp[n][i];
        }
        long ans = 0;
        int mod = 1000000007;
        if (i == 0) {
            ans = (ans + dfs(n - 1, 1, dp)) % mod;
        } else if (i == 1) {
            ans = (ans + dfs(n - 1, 0, dp)) % mod;
            ans = (ans + dfs(n - 1, 2, dp)) % mod;
        } else if (i == 2) {
            ans = (ans + dfs(n - 1, 0, dp)) % mod;
            ans = (ans + dfs(n - 1, 1, dp)) % mod;
            ans = (ans + dfs(n - 1, 3, dp)) % mod;
            ans = (ans + dfs(n - 1, 4, dp)) % mod;
        } else if (i == 3) {
            ans = (ans + dfs(n - 1, 2, dp)) % mod;
            ans = (ans + dfs(n - 1, 4, dp)) % mod;
        } else {
            ans = (ans + dfs(n - 1, 0, dp)) % mod;
        }
        dp[n][i] = ans;
        return ans;
    }
}