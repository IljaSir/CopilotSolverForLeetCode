class Solution {
    public int minCut(String s) {
        
        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                isPalindrome[i][i + len - 1] = (s.charAt(i) == s.charAt(i + len - 1) && isPalindrome[i + 1][i + len - 2]);
            }
        }
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            if (isPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            dp[i] = i;
            for (int j = 1; j <= i; j++) {
                if (isPalindrome[j][i]) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}