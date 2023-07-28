class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i - 1);
            if (c == '*') {
                dp[i] = dp[i - 1] * 9;
                if (i > 1) {
                    char p = s.charAt(i - 2);
                    if (p == '*') {
                        dp[i] += dp[i - 2] * 15;
                    } else if (p == '1') {
                        dp[i] += dp[i - 2] * 9;
                    } else if (p == '2') {
                        dp[i] += dp[i - 2] * 6;
                    }
                }
            } else {
                if (c != '0') {
                    dp[i] = dp[i - 1];
                }
                if (i > 1) {
                    char p = s.charAt(i - 2);
                    if (p == '*') {
                        if (c <= '6') {
                            dp[i] += dp[i - 2] * 2;
                        } else {
                            dp[i] += dp[i - 2];
                        }
                    } else if (p == '1') {
                        dp[i] += dp[i - 2];
                    } else if (p == '2' && c <= '6') {
                        dp[i] += dp[i - 2];
                    }
                }
            }
            dp[i] %= mod;
        }
        return (int) dp[n];
    }
}