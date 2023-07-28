class Solution {
    public int longestValidParentheses(String s) {
        
        int N = s.length();
        if (N <= 1) {
            return 0;
        }
        int[] dp = new int[N];
        int max = 0;
        for (int i = 1; i < N; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = i - 2 >= 0 ? dp[i - 2] + 2 : 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + 2 + (i - dp[i - 1] - 2 >= 0 ? dp[i - dp[i - 1] - 2] : 0);
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}