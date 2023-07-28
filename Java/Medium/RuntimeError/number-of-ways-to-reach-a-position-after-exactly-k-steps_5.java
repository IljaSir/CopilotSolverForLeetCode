class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        
        int MOD = 1_000_000_007;
        int[] dp = new int[1001];
        dp[startPos] = 1;
        for (int i = 0; i < k; i++) {
            int[] ndp = new int[1001];
            for (int j = 1; j <= 1000; j++) {
                ndp[j] = (dp[j - 1] + dp[j + 1]) % MOD;
            }
            dp = ndp;
        }
        return dp[endPos];
    }
}