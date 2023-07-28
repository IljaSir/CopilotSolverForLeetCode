class Solution {
    public int numDecodings(String s) {
        
        int MOD = 1000000007;
        long[] dp = new long[s.length() + 1];
        dp[0] = 1;
        for (int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            if (c == '*') {
                dp[i] = 9 * dp[i - 1];
                if (i > 1) {
                    char p = s.charAt(i - 2);
                    if (p == '1') {
                        dp[i] = (dp[i] + 9 * dp[i - 2]) % MOD;
                    } else if (p == '2') {
                        dp[i] = (dp[i] + 6 * dp[i - 2]) % MOD;
                    } else if (p == '*') {
                        dp[i] = (dp[i] + 15 * dp[i - 2]) % MOD;
                    }
                }
            } else {
                dp[i] = c == '0' ? 0 : dp[i - 1];
                if (i > 1) {
                    char p = s.charAt(i - 2);
                    if (p == '1' || p == '2' && c <= '6') {
                        dp[i] = (dp[i] + dp[i - 2]) % MOD;
                    } else if (p == '*') {
                        dp[i] = (dp[i] + (c <= '6' ? 2 : 1) * dp[i - 2]) % MOD;
                    }
                }
            }
        }
        return (int) dp[s.length()];
    }
}