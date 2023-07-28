class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (1 << n); j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(statements, 0, 0, dp);
    }

    int dfs(int[][] statements, int person, int mask, int[][] dp) {
        if (person == statements.length) {
            return 0;
        }
        if (dp[person][mask] != -1) {
            return dp[person][mask];
        }
        int res = 0;
        for (int i = 0; i < statements.length; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            if (statements[person][i] == 0) {
                res = Math.max(res, dfs(statements, person + 1, mask | (1 << i), dp));
            } else if (statements[person][i] == 1) {
                res = Math.max(res, 1 + dfs(statements, person + 1, mask | (1 << i), dp));
            } else {
                res = Math.max(res, 1 + dfs(statements, person + 1, mask, dp));
            }
        }
        dp[person][mask] = res;
        return res;
    }
}