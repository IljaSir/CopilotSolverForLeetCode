class Solution {
    public int numDecodings(String s) {
        
        int mod = 1000000007;
        int n = s.length();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == '*') {
                dp[i + 1] = dp[i] * 9;
                if (i > 0) {
                    char p = s.charAt(i - 1);
                    if (p == '*') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1] * 15;
                    } else if (p == '1') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1] * 9;
                    } else if (p == '2') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1] * 6;
                    }
                }
            } else if (c == '0') {
                if (i > 0) {
                    char p = s.charAt(i - 1);
                    if (p == '*') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1] * 2;
                    } else if (p == '1' || p == '2') {
                        dp[i + 1] = dp[i - 1];
                    } else {
                        return 0;
                    }
                }
            } else {
                dp[i + 1] = dp[i];
                if (i > 0) {
                    char p = s.charAt(i - 1);
                    if (p == '*') {
                        if (c <= '6') {
                            dp[i + 1] = dp[i + 1] + dp[i - 1] * 2;
                        } else {
                            dp[i + 1] = dp[i + 1] + dp[i - 1];
                        }
                    } else if (p == '1') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1];
                    } else if (p == '2' && c <= '6') {
                        dp[i + 1] = dp[i + 1] + dp[i - 1];
                    }
    }
}