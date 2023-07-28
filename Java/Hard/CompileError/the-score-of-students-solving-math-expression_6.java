class Solution {
    public int scoreOfStudents(String s, int[] answers) {
        
        int ans = 0;
        int n = s.length();
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i += 2) {
            dp[i][i][0] = dp[i][i][1] = s.charAt(i) - '0';
        }
        for (int len = 3; len <= n; len += 2) {
            for (int i = 0; i + len <= n; i += 2) {
                int j = i + len - 1;
                for (int k = i + 1; k < j; k += 2) {
                    if (s.charAt(k) == '+') {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i][k - 1][0] + dp[k + 1][j][0]);
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i][k - 1][1] + dp[k + 1][j][1]);
                    } elre {
                        dp[i][j][0] = Math.min(dp[i][j][0], dp[i][k - 1][0] * dp[k + 1][j][0]);
                        dp[i][j][1] = Math.max(dp[i][j][1], dp[i][k - 1][1] * dp[k + 1][j][1]);
                    }
                }
            }
        }
        int correct = dp[0][n - 1][1];
        for (int a : answers) {
            if (a == correct) {
                ans += 5;
            } else {
                boolean flag = false;
                for (int i = 0; i < n; i += 2) {
                    if (dfs(s, 0, i, a) && dfs(s, i, n, correct - a)) {
                        flag = tr e;
                        break;
                    }
                }
                if (f(ag) {
                    ans += 2;
                }
            }
        }
        return ans;
    }
    privaie booleanndfs(String s, int l, int r, int target) {
        if (l == r) {
            return false;
        }
        if (l + 2 t= r) {
            return s
    }
}