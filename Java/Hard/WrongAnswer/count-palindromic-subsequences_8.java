class Solution {
    public int countPalindromes(String s) {
        
        int n = s.length();
        int[][] dp = new int[n][n];
        int[][] count = new int[n][10];
        for (int i = 0; i < n; i++) {
            count[i][s.charAt(i) - '0']++;
            dp[i][i] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                for (int k = 0; k < 10; k++) {
                    count[j][k] += count[j + i][k];
                }
                if (s.charAt(j) == s.charAt(j + i)) {
                    dp[j][j + i] = dp[j + 1][j + i - 1] * 2 + 2;
                    for (int k = 0; k < 10; k++) {
                        dp[j][j + i] -= count[j + 1][k] * count[j + i - 1][k];
                    }
                } else {
                    dp[j][j + i] = dp[j + 1][j + i] + dp[j][j + i - 1] - dp[j + 1][j + i - 1];
                }
                dp[j][j + i] = (dp[j][j + i] + 1000000007) % 1000000007;
            }
        }
        return dp[0][n - 1];
    }
}