class Solution {
    public int[] maxPoints(int[][] grid, int[] queries) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int max = 0;
                if (i > 0) max = Math.max(max, dp[i - 1][j]);
                if (j > 0) max = Math.max(max, dp[i][j - 1]);
                if (i > 0 && j > 0) max = Math.max(max, dp[i - 1][j - 1]);
                dp[i][j] = max + (grid[i][j] > queries[0] ? 1 : 0);
            }
        }
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int max = 0;
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    int val = dp[j][k];
                    if (j > 0) val -= dp[j - 1][k];
                    if (k > 0) val -= dp[j][k - 1];
                    if (j > 0 && k > 0) val += dp[j - 1][k - 1];
                    if (grid[j][k] > queries[i]) val += 1;
                    max = Math.max(max, val);
                }
            }
            ans[i] = max;
        }
        return ans;
    }
}