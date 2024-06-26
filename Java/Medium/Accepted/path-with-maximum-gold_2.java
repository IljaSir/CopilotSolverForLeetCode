class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] > 0) {
                    max = Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }
        int gold = grid[i][j];
        grid[i][j] = 0;
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);
        int top = dfs(grid, i - 1, j);
        int bottom = dfs(grid, i + 1, j);
        grid[i][j] = gold;
        return gold + Math.max(left, Math.max(right, Math.max(top, bottom)));
    }
}