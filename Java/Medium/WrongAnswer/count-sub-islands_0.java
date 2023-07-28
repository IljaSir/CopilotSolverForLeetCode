class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[i].length; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid2.length || j < 0 || j >= grid2[i].length || grid2[i][j] == 0) {
            return true;
        }
        grid2[i][j] = 0;
        boolean ret = grid1[i][j] == 1 && dfs(grid1, grid2, i - 1, j) && dfs(grid1, grid2, i + 1, j) && dfs(grid1, grid2, i, j - 1) && dfs(grid1, grid2, i, j + 1);
        return ret;
    }
}