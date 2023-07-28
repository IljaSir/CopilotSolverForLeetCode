class Solution {
    public int countPalindromicSubsequence(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                int k = j + i;
                if (s.charAt(j) != s.charAt(k)) {
                    dp[j][k] = dp[j + 1][k] + dp[j][k - 1] - dp[j + 1][k - 1];
                } else {
                    int l = j + 1;
                    int r = k - 1;
                    while (l <= r && s.charAt(l) != s.charAt(j)) {
                        l++;
                    }
                    while (l <= r && s.charAt(r) != s.charAt(j)) {
                        r--;
                    }
                    if (l > r) {
                        dp[j][k] = dp[j + 1][k - 1] * 2 + 2;
                    } else if (l == r) {
                        dp[j][k] = dp[j + 1][k - 1] * 2 + 1;
                    } else {
                        dp[j][k] = dp[j + 1][k - 1] * 2 - dp[l + 1][r - 1];
                    }
                }
                dp[j][k] = Math.max(dp[j][k], 0);
            }
        }
        return dp[0][n - 1];
    }
}