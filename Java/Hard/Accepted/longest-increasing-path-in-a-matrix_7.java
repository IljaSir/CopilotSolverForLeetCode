class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j, m, n, memo));
            }
        }
        return ans;
    }
    
    private int dfs(int[][] matrix, int i, int j, int m, int n, int[][] memo) {
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        int ans = 1;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, i - 1, j, m, n, memo));
        }
        if (i + 1 < m && matrix[i + 1][j] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, i + 1, j, m, n, memo));
        }
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, i, j - 1, m, n, memo));
        }
        if (j + 1 < n && matrix[i][j + 1] > matrix[i][j]) {
            ans = Math.max(ans, 1 + dfs(matrix, i, j + 1, m, n, memo));
        }
        memo[i][j] = ans;
        return ans;
    }
}