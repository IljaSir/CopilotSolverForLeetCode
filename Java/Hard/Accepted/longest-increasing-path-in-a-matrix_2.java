class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, m, n, dp));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i - 1, j, m, n, dp));
        }
        if (i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i + 1, j, m, n, dp));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i, j - 1, m, n, dp));
        }
        if (j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i, j + 1, m, n, dp));
        }
        dp[i][j] = max + 1;
        return dp[i][j];
    }
}