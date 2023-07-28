class Solution {
    public int maximumGood(int[][] statements) {
        
        int n = statements.length;
        int[][] dp = new int[1<<n][n];
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        return dfs(statements, 0, 0, dp);
    }
    
    private int dfs(int[][] statements, int mask, int person, int[][] dp) {
        if (person == statements.length) {
            return 0;
        }
        if (dp[mask][person] != -1) {
            return dp[mask][person];
        }
        int n = statements.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1<<i)) == 0) {
                int nextMask = mask | (1<<i);
                if (statements[person][i] == 0) {
                    ans = Math.max(ans, dfs(statements, nextMask, person+1, dp));
                } else if (statements[person][i] == 1) {
                    ans = Math.max(ans, 1 + dfs(statements, nextMask, person+1, dp));
                } else {
                    ans = Math.max(ans, dfs(statements, nextMask, person+1, dp));
                    ans = Math.max(ans, 1 + dfs(statements, nextMask, person+1, dp));
                }
            }
        }
        return dp[mask][person] = ans;
    }
}