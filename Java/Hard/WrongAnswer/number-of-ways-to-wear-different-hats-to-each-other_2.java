class Solution {
    public int numberWays(List<List<Integer>> hats) {
        
        int mod = 1000000007;
        int n = hats.size();
        int[][] dp = new int[1 << n][41];
        dp[0][0] = 1;
        for (int j = 1; j <= 40; j++) {
            for (int i = 0; i < (1 << n); i++) {
                dp[i][j] = dp[i][j - 1];
                for (int k = 0; k < n; k++) {
                    if (((i >> k) & 1) == 1 || !hats.get(k).contains(j)) continue;
                    dp[i | (1 << k)][j] = (dp[i | (1 << k)][j] + dp[i][j - 1]) % mod;
                }
            }
        }
        return dp[(1 << n) - 1][40];
    }
}