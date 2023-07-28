class Solution {
    public int numDecodings(String s) {
        
        int n = s.length();
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : (s.charAt(0) == '0' ? 0 : 1);
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '*') {
                dp[i+1] = dp[i] * 9;
                if (s.charAt(i-1) == '1') {
                    dp[i+1] += dp[i-1] * 9;
                } else if (s.charAt(i-1) == '2') {
                    dp[i+1] += dp[i-1] * 6;
                } else if (s.charAt(i-1) == '*') {
                    dp[i+1] += dp[i-1] * 15;
                }
            } else {
                dp[i+1] = s.charAt(i) != '0' ? dp[i] : 0;
                if (s.charAt(i-1) == '1') {
                    dp[i+1] += dp[i-1];
                } else if (s.charAt(i-1) == '2' && s.charAt(i) <= '6') {
                    dp[i+1] += dp[i-1];
                } else if (s.charAt(i-1) == '*') {
                    dp[i+1] += (s.charAt(i) <= '6' ? dp[i-1] * 2 : dp[i-1]);
                }
            }
            dp[i+1] %= 1000000007;
        }
        return (int)dp[n];
    }
}