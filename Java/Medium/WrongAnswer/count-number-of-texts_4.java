class Solution {
    public int countTexts(String pressedKeys) {
        
        int n = pressedKeys.length();
        int mod = 1000000007;
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i=1; i<=n; i++) {
            int c = pressedKeys.charAt(i-1) - '0';
            if (c == 0 || c == 1) {
                return 0;
            }
            dp[i] = dp[i-1];
            if (i > 1) {
                int p = pressedKeys.charAt(i-2) - '0';
                if (p == 7 || p == 9) {
                    if (c == p) {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    }
                } else {
                    if (c == p) {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    } else if (c == p + 1) {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    }
                }
            }
        }
        return dp[n];
    }
}