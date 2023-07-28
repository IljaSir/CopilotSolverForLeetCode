class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = 1000000007;
        int n = locations.length;
        int[][] dp = new int[fuel + 1][n];
        dp[0][start] = 1;
        for (int i = 0; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        int diff = Math.abs(locations[j] - locations[k]);
                        if (i >= diff) {
                            dp[i][j] = (dp[i][j] + dp[i - diff][k]) % mod;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i <= fuel; i++) {
            ans = (ans + dp[i][finish]) % mod;
        }
        return ans;
    }
}