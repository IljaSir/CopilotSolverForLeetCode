class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int M = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        char[] arr = s.toCharArray();
        for (int i = 1; i <= n; i++) {
            char c = arr[i - 1];
            if (c == '*') {
                dp[i] = 9 * dp[i - 1];
                if (i > 1) {
                    char p = arr[i - 2];
                    if (p == '1') {
                        dp[i] = (dp[i] + 9 * dp[i - 2]) % M;
                    } else if (p == '2') {
                        dp[i] = (dp[i] + 6 * dp[i - 2]) % M;
                    } else if (p == '*') {
                        dp[i] = (dp[i] + 15 * dp[i - 2]) % M;
                    }
                }
            } else {
                dp[i] = c == '0' ? 0 : dp[i - 1];
                if (i > 1) {
                    char p = arr[i - 2];
                    if (p == '1') {
                        dp[i] = (dp[i] + dp[i - 2]) % M;
                    } else if (p == '2' && c <= '6') {
                        dp[i] = (dp[i] + dp[i - 2]) % M;
                    } else if (p == '*') {
                        dp[i] = (dp[i] + (c <= '6' ? 2 : 1) * dp[i - 2]) % M;
                    }
                }
            }
        }
        return (int) dp[n];
    }
}