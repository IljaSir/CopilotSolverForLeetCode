class Solution {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        
        int mod = 1000000007;
        int[][] dp = new int[fuel + 1][locations.length];
        dp[0][start] = 1;
        for (int i = 1; i <= fuel; i++) {
            for (int j = 0; j < locations.length; j++) {
                for (int k = 0; k < locations.length; k++) {
                    if (j == k) continue;
                    dp[i][j] = (dp[i][j] + dp[i - Math.abs(locations[j] - locations[k])][k]) % mod;
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