class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        int mod = (int) 1e9 + 7;
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '*') {
                dp[i + 1] = 9 * dp[i];
                if (i > 0 && s.charAt(i - 1) == '1') {
                    dp[i + 1] += 9 * dp[i - 1];
                } else if (i > 0 && s.charAt(i - 1) == '2') {
                    dp[i + 1] += 6 * dp[i - 1];
                } else if (i > 0 && s.charAt(i - 1) == '*') {
                    dp[i + 1] += 15 * dp[i - 1];
                }
            } else {
                dp[i + 1] = s.charAt(i) == '0' ? 0 : dp[i];
                if (i > 0 && s.charAt(i - 1) == '1') {
                    dp[i + 1] += dp[i - 1];
                } else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6') {
                    dp[i + 1] += dp[i - 1];
                } else if (i > 0 && s.charAt(i - 1) == '*') {
                    dp[i + 1] += (s.charAt(i) <= '6' ? 2 : 1) * dp[i - 1];
                }
            }
            dp[i + 1] %= mod;
        }
        return dp[n];
    }
}