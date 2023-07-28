class Solution {
    public int beautifulPartitions(String s, int k, int minLength) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(s, 0, n - 1, k, minLength, dp);
    }

    private int dfs(String s, int l, int r, int k, int minLength, int[][] dp) {
        if (dp[l][r] != -1) {
            return dp[l][r];
        }
        if (k == 1) {
            if (isPrime(s.charAt(l)) && !isPrime(s.charAt(r)) && r - l + 1 >= minLength) {
                return 1;
            } else {
                return 0;
            }
        }
        int ans = 0;
        for (int i = l + minLength - 1; i < r; i++) {
            if (isPrime(s.charAt(l)) && !isPrime(s.charAt(i))) {
                ans = (ans + dfs(s, l + 1, i, 1, minLength, dp) * dfs(s, i + 1, r, k - 1, minLength, dp)) % 1000000007;
            }
        }
        dp[l][r] = ans;
        return ans;
    }
}