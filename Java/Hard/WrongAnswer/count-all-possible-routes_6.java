class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = 1000000007;
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        dp[start][0] = 1;
        for (int i = 1; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    dp[j][i] = (dp[j][i] + dp[k][i - 1]) % mod;
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= fuel; i++) {
            ans = (ans + dp[finish][i]) % mod;
        }
        return ans;
    }
}