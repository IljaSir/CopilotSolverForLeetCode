class Solution {
    public int minOperationsToFlip(String expression) {
        
        int n = expression.length();
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < n; i++) {
            char c = expression.charAt(i);
            if (c == '0') {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            } else if (c == '1') {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            } else if (c == '&') {
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
                dp[i + 1] = Math.min(dp[i + 1], dp[i]);
            } else if (c == '|') {
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            } else if (c == '(') {
                int j = i + 1;
                for (int cnt = 1; j < n; j++) {
                    if (expression.charAt(j) == '(') {
                        cnt++;
                    } else if (expression.charAt(j) == ')') {
                 ;
    }
}