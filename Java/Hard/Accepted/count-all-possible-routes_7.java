class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = (int)1e9 + 7;
        int n = locations.length;
        int[][] dp = new int[n][fuel + 1];
        dp[start][fuel] = 1;
        for (int i = fuel; i > 0; i--) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        int cost = Math.abs(locations[j] - locations[k]);
                        if (i >= cost) {
                            dp[j][i - cost] = (dp[j][i - cost] + dp[k][i]) % mod;
                        }
                    }
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