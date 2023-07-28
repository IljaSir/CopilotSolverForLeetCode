class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                dp[i+1] = dp[i] * 9;
                if (i > 0) {
                    char p = s.charAt(i-1);
                    if (p == '1') {
                        dp[i+1] += dp[i-1] * 9;
                    } else if (p == '2') {
                        dp[i+1] += dp[i-1] * 6;
                    } else if (p == '*') {
                        dp[i+1] += dp[i-1] * 15;
                    }
                }
            } else {
                if (c != '0') dp[i+1] = dp[i];
                if (i > 0) {
                    char p = s.charAt(i-1);
                    if (p == '1') {
                        dp[i+1] += dp[i-1];
                    } else if (p == '2' && c <= '6') {
                        dp[i+1] += dp[i-1];
                    } else if (p == '*') {
                        dp[i+1] += dp[i-1] * (c <= '6' ? 2 : 1);
                    }
                }
            }
            dp[i+1] %= 1000000007;
        }
        return (int)dp[n];
    }
}