class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] memo = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j, memo));
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int i, int j, int[][] memo) {
        if (memo[i][j] > 0) {
            return memo[i][j];
        }
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int max = 0;
        for (int[] dir : dirs) {
            int newI = i + dir[0];
            int newJ = j + dir[1];
            if (newI < 0 || newI >= matrix.length || newJ < 0 || newJ >= matrix[0].length || matrix[newI][newJ] <= matrix[i][j]) {
                continue;
            }
            max = Math.max(max, dfs(matrix, newI, newJ, memo));
        }
        memo[i][j] = max + 1;
        return memo[i][j];
    }
}