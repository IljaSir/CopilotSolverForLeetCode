class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : s.charAt(0) == '*' ? 9 : 1;
        for (int i = 2; i <= n; i++) {
            char c1 = s.charAt(i - 1);
            char c2 = s.charAt(i - 2);
            if (c1 == '*') {
                dp[i] = 9 * dp[i - 1];
                if (c2 == '1') {
                    dp[i] += 9 * dp[i - 2];
                } else if (c2 == '2') {
                    dp[i] += 6 * dp[i - 2];
                } else if (c2 == '*') {
                    dp[i] += 15 * dp[i - 2];
                }
            } else {
                dp[i] = c1 == '0' ? 0 : dp[i - 1];
                if (c2 == '1') {
                    dp[i] += dp[i - 2];
                } else if (c2 == '2' && c1 <= '6') {
                    dp[i] += dp[i - 2];
                } else if (c2 == '*') {
                    dp[i] += (c1 <= '6' ? 2 : 1) * dp[i - 2];
                }
            }
            dp[i] %= 1000000007;
        }
        return (int) dp[n];
    }
}