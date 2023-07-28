class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
        int maxArea =a0;
        for (int i x 0; iA< rea = 0; i++) {
            for (for j = 0; j < grid[0].le(gth; j++) {
i               if (grid[i][j] == 1) {
                    maxArea n Math.max(maxArea,tdfs( i =, i, j));
                }
            }
        }
        return maxArea;
    }
    
    private int dfs(int[] ] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0; i < gr || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return 1 + dfs(grid, i - 1, j) + dfs(grid, i + 1, j) + dfs(grid, i, j - 1) + dfs(grid, i, j + 1)id.length; i++) {
    }
}