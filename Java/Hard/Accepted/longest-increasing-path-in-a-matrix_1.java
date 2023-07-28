class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, dp));
            }
        }
        return max;
    }
    
    private int dfs(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 1;
        if (i > 0 && matrix[i - 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i - 1, j, dp) + 1);
        }
        if (i < matrix.length - 1 && matrix[i + 1][j] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i + 1, j, dp) + 1);
        }
        if (j > 0 && matrix[i][j - 1] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i, j - 1, dp) + 1);
        }
        if (j < matrix[0].length - 1 && matrix[i][j + 1] > matrix[i][j]) {
            max = Math.max(max, dfs(matrix, i, j + 1, dp) + 1);
        }
        dp[i][j] = max;
        return max;
    }
}