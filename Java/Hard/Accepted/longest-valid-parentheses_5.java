class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        dp[0] = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    if (i >= 2) {
                        dp[i] = dp[i - 2] + 2;
                    }
                    else {
                        dp[i] = 2;
                    }
                }
                else {
                    int pre = i - dp[i - 1] - 1;
                    if (pre >= 0 && s.charAt(pre) == '(') {
                        if (pre >= 1) {
                            dp[i] = dp[i - 1] + 2 + dp[pre - 1];
                        }
                        else {
                            dp[i] = dp[i - 1] + 2;
                        }
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}