class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, dp));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int ans = 1;
        if (i > 0 && matrix[i][j] < matrix[i - 1][j]) {
            ans = Math.max(ans, dfs(matrix, i - 1, j, dp) + 1);
        }
        if (i < m - 1 && matrix[i][j] < matrix[i + 1][j]) {
            ans = Math.max(ans, dfs(matrix, i + 1, j, dp) + 1);
        }
        if (j > 0 && matrix[i][j] < matrix[i][j - 1]) {
            ans = Math.max(ans, dfs(matrix, i, j - 1, dp) + 1);
        }
        if (j < n - 1 && matrix[i][j] < matrix[i][j + 1]) {
            ans = Math.max(ans, dfs(matrix, i, j + 1, dp) + 1);
        }
        dp[i][j] = ans;
        return ans;
    }
}