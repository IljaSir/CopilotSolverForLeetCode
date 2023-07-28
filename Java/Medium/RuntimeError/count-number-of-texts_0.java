class Solution {
    public int countTexts(String pressedKeys) {
        
        int MOD = 1000000007;
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = pressedKeys.charAt(i - 1) - '0';
            if (x == 0 || x == 1) {
                return 0;
            }
            if (x == 7 || x == 9) {
                dp[i] = ((dp[i - 1] * 4) % MOD + dp[i - 2]) % MOD;
            } else {
                dp[i] = ((dp[i - 1] * 3) % MOD + dp[i - 2]) % MOD;
            }
        }
        return dp[n];
    }
}