class Solution {
    public int countPalindromicSubsequences(String s) {
        
        int n = s.length();
        int mod = 1000000007;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int i = 0; i < n - 1; i++) {
            dp[i][i + 1] = 2;
        }
        for (int l = 3; l <= n; l++) {
            for (int i = 0; i + l - 1 < n; i++) {
                int j = i + l - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    int left = i + 1;
                    int right = j - 1;
                    while (left <= right && s.charAt(left) != s.charAt(i)) {
                        left++;
                    }
                    while (left <= right && s.charAt(right) != s.charAt(i)) {
                        right--;
                    }
                    if (left > right) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 2;
                    } else if (left == right) {
                        dp[i][j] = dp[i + 1][j - 1] * 2 + 1;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1] * 2 - dp[left + 1][right - 1];
                    }
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return dp[0][n - 1];
    }
}