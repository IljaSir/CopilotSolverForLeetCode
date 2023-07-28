class Solution {
    public int numDecodings(String s) {
        
        int mod = 1000000007;
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i-1) == '0') {
                dp[i] = 0;
            } else if (s.charAt(i-1) == '*') {
                dp[i] = 9 * dp[i-1];
            } else {
                dp[i] = dp[i-1];
            }
            if (i >= 2) {
                if (s.charAt(i-2) == '1') {
                    if (s.charAt(i-1) == '*') {
                        dp[i] = (dp[i] + 9 * dp[i-2]) % mod;
                    } else {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    }
                } else if (s.charAt(i-2) == '2') {
                    if (s.charAt(i-1) == '*') {
                        dp[i] = (dp[i] + 6 * dp[i-2]) % mod;
                    } else if (s.charAt(i-1) >= '0' && s.charAt(i-1) <= '6') {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    }
                } else if (s.charAt(i-2) == '*') {
                    if (s.charAt(i-1) == '*') {
                        dp[i] = (dp[i] + 15 * dp[i-2]) % mod;
                    } else if (s.charAt(i-1) >= '0' && s.charAt(i-1) <= '6') {
                        dp[i] = (dp[i] + 2 * dp[i-2]) % mod;
                    } else {
                        dp[i] = (dp[i] + dp[i-2]) % mod;
                    }
                }
            }
        }
        return (int)dp[n];
    }
}