class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int n = locations.length;
        int mod = 1000000007;
        int[][] dp = new int[n][fuel + 1];
        dp[start][0] = 1;
        for (int k = 1; k <= fuel; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j) {
                        continue;
                    }
                    int dist = Math.abs(locations[i] - locations[j]);
                    if (dist <= k) {
                        dp[i][k] = (dp[i][k] + dp[j][k - dist]) % mod;
                    }
                }
            }
        }
        int ans = 0;
        for (int k = 0; k <= fuel; k++) {
            ans = (ans + dp[finish][k]) % mod;
        }
        return ans;
    }
}