class Solution {
    public int countPalindromicSubsequences(String s) {
        
        int N = s.length();
        int MOD = 1000000007;
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            dp[i][i] = 1;
        }
        for (int i = N - 1; i >= 0; i--) {
            for (int j = i + 1; j < N; j++) {
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
                dp[i][j] = (dp[i][j] + MOD) % MOD;
            }
        }
        return dp[0][N - 1];
    }
}