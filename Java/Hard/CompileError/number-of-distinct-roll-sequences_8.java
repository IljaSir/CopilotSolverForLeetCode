class Solution {
    public int distinctSequences(int n) {
        
        int MOD = 1_000_000_007;
        int[][] dp = new int[6][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    if (gcd(j + 1, k + 1) == 1) {
                        dp[j][i] = (dp[j][i] + dp[k][i - 1]) % MOD;
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < 6; i++) {
            res = (res + dp[i][n - 1]) % MOD;
        }
        return res;
    }
}