class Solution {
    public int getMaximumGold(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int max = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] != 0) {
                    max = Math.max(max, dfs(grid, visited, i, j, 0));
                }
            }
        }
        return max;
    }
    
    private int dfs(int[][] grid, boolean[][] visited, int i, int j, int count) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return count;
        }
        visited[i][j] = true;
        int max = 0;
        max = Math.max(max, dfs(grid, visited, i - 1, j, count + grid[i][j]));
        max = Math.max(max, dfs(grid, visited, i + 1, j, count + grid[i][j]));
        max = Math.max(max, dfs(grid, visited, i, j - 1, count + grid[i][j]));
        max = Math.max(max, dfs(grid, visited, i, j + 1, count + grid[i][j]));
        visited[i][j] = false;
        return max;
    }
}