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
            if ((mask & (1 << i)) != 0) {ount(i));
            }
        }
        return res;
    }
}