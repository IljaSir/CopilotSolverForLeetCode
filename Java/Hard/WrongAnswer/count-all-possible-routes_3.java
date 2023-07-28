class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = 1000000007;
        int n = locations.length;
        long[][] dp = new long[fuel + 1][n];
        dp[0][start] = 1;
        for (int i = 1; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        dp[i][j] += dp[i - 1][k];
                        dp[i][j] %= mod;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                long temp = 0;
                for (int k = 0; k < n; k++) {
                    if (k != j) {
                        int dis = Math.abs(locations[j] - locations[k]);
                        if (dis <= i) {
                            temp += dp[i - dis][k];
                            temp %= mod;
                        }
                    }
                }
                dp[i][j] += temp;
                dp[i][j] %= mod;
            }
        }
        return (int) dp[fuel][finish];
    }
}