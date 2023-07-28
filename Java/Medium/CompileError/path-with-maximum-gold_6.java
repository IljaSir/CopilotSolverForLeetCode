class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (grid[i][j] == 0) continue;
                max = Math.max(max, dfs(grid, i, j));
            }
        }
        return max;
    }
}