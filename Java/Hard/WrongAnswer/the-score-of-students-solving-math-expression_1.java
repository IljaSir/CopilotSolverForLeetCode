class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i += 2) {
            dp[i][i][0] = s.charAt(i) - '0';
            dp[i][i][1] = s.charAt(i) - '0';
        }
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i <= n - len; i += 2) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k += 2) {
                    if (s.charAt(k) == '+') {
                        dp[i][j][0] += dp[i][k - 1][0] + dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][1] + dp[k + 1][j][1];
                    } else {
                        dp[i][j][0] += dp[i][k - 1][0] * dp[k + 1][j][0];
                        dp[i][j][1] += dp[i][k - 1][1] * dp[k + 1][j][1];
                    }
                }
                if (s.charAt(i) == '0') {
                    dp[i][j][0] = 0;
                }
                if (s.charAt(j) == '0') {
                    dp[i][j][1] = 0;
                }
            }
        }
        int ans = 0;
        int correct = dp[0][n - 1][0];
        for (int answer : answers) {
            if (answer == correct) {
                ans += 5;
            } else if (answer == dp[0][n - 1][1]) {
                ans += 2;
            }
        }
        return ans;
    }
}