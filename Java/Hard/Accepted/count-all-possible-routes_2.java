class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = 1000000007;
        int n = locations.length;
        long[][] dp = new long[fuel + 1][n];
        dp[0][start] = 1;
        for (int i = 1; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k) {
                        continue;
                    }
                    int cost = Math.abs(locations[j] - locations[k]);
                    if (cost > i) {
                        continue;
                    }
                    dp[i][j] = (dp[i][j] + dp[i - cost][k]) % mod;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i <= fuel; i++) {
            ans = (ans + dp[i][finish]) % mod;
        }
        return (int) ans;
    }
}