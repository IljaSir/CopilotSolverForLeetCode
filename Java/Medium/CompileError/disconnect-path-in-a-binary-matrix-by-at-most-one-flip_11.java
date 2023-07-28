class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(grid, 0, 0, dp) == 0;
    }
    
    private int dfs(int[][] grid, int i, int j, int[][] dp) {
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return 1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int result = 0;
        if (i + 1 < grid.length && grid[i + 1][j] == 1) {
            result += dfs(grid, i + 1, j, dp);
            if (result >= 2) {
                return dp[i][j] = 2;
            }
        }
        if (j + 1 < grid[0].length && grid[i][j + 1] == 1) {
            result += dfs(grid, i, j + 1, dp);
            if (result >= 2) {
                return dp[i][j] = 2;
            }
        }
        return dp[i][j] = result;
    }
}
    }
}