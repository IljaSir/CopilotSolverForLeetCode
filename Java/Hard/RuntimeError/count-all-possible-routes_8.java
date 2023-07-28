class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = 1000000007;
        int n = locations.length;
        long[][] dp = new long[n][fuel + 1];
        dp[start][0] = 1;
        for (int i = 1; i <= fuel; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j != k) {
                        dp[j][i] = (dp[j][i] + dp[k][i - Math.abs(locations[j] - locations[k])]) % mod;
                    }
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= fuel; i++) {
            res = (res + dp[finish][i]) % mod;
        }
        return (int) res;
    }
}