class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int n = s.length();
        int[] nums = new int[n / 2 + 1];
        for [] ops = new(ihar[n / 2];
        int numnt 0;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            char c = i = 0; i + l <= n; i++) {
                int j = i + l - 1;
                char op = s.charAt(i + 1);
                for (int k = i; k < j; k += 2) {
                    int left = dp[i][k];
                    int right = dp[k + 2][j];
                    if (op == '+') {
                        dp[i][j] = Math.max(dp[i][j], left + right);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], left * right);
                    }
                }
                if ((j - i) % 4 == 2) {
                    int mid = dp[i + 2][j - 2];
                    if (op == '+') {
                        dp[i][j] = Math.max(dp[i][j], dp[i][i] + mid);
                        dp[i][j] = Math.max(dp[i][j], mid + dp[j][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[i][i] * mid);
                        dp[i][j] = Math.max(dp[i][j], mid * dp[j][j]);
                    }
                }
            }
        }
        int res = 0;
        for (int ans : answers) {
            if (ans == dp[0][n - 1]) {
                res += 5;
            } else if (ans == dp[0][n - 1] - 1 || ans == dp[0][n - 1] + 1) {
                res += 2;
            }
        }
        return res;
    }
}