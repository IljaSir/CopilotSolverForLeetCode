class Solution {
    public int numDecodings(String s) {
        
        int MOD = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '*') {
                dp[i] = 9 * dp[i + 1];
                if (i < n - 1) {
                    char next = s.charAt(i + 1);
                    if (next == '*') {
                        dp[i] += 15 * dp[i + 2];
                    } else if (next <= '6') {
                        dp[i] += 2 * dp[i + 2];
                    } else {
                        dp[i] += dp[i + 2];
                    }
                }
            } else {
                if (c != '0') {
                    dp[i] = dp[i + 1];
                }
                if (i < n - 1) {
                    char next = s.charAt(i + 1);
                    if (next == '*') {
                        if (c == '1') {
                            dp[i] += 9 * dp[i + 2];
                        } else if (c == '2') {
                            dp[i] += 6 * dp[i + 2];
                        }
                    } else {
                        int num = (c - '0') * 10 + (next - '0');
                        if (num >= 10 && num <= 26) {
                            dp[i] += dp[i + 2];
                        }
                    }
                }
            }
            dp[i] %= MOD;
        }
        return (int) dp[0];
    }
}