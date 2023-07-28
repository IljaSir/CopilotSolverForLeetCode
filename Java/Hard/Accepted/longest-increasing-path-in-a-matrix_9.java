class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int max = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int len = dfs(matrix, i, j, dp, directions, m, n);
                max = Math.max(max, len);
            }
        }
        return max;
    }
    private int dfs(int[][] matrix, int i, int j, int[][] dp, int[][] directions, int m, int n) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int max = 1;
        for (int[] direction : directions) {
            int x = i + direction[0], y = j + direction[1];
            if (x >= 0 && x < m && y >= 0 && y < n && matrix[x][y] > matrix[i][j]) {
                int len = 1 + dfs(matrix, x, y, dp, directions, m, n);
                max = Math.max(max, len);
            }
        }
        dp[i][j] = max;
        return max;
    }
}