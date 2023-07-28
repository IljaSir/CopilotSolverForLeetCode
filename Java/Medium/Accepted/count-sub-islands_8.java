class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int n = grid1.length;
        int m = grid1[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    boolean subIsland = dfs(grid1, grid2, i, j);
                    if (subIsland) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        int n = grid1.length;
        int m = grid1[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || grid2[i][j] == 0) {
            return true;
        }
        if (grid1[i][j] == 0) {
            return false;
        }
        grid2[i][j] = 0;
        boolean left = dfs(grid1, grid2, i, j - 1);
        boolean right = dfs(grid1, grid2, i, j + 1);
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean down = dfs(grid1, grid2, i + 1, j);
        return left && right && up && down;
    }
}