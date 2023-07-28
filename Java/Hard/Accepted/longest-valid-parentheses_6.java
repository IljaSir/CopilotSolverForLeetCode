class Solution {
    public int longestValidParentheses(String s) {
        
        int n = s.length();
        int[] dp = new int[n + 1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) == '(') {
                dp[i] = 0;
                continue;
            }
            if (i - 2 >= 0 && s.charAt(i - 2) == '(') {
                dp[i] = dp[i - 2] + 2;
            } else if (i - 2 - dp[i - 1] >= 0 && s.charAt(i - 2 - dp[i - 1]) == '(') {
                dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}