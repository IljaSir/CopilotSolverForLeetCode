class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        if (grid1 == null || grid2 == null) {
            return 0;
        }
        int m = grid1.length;
        int n = grid1[0].length;
        
        int[][] visited = new int[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && visited[i][j] == 0) {
                    if (dfs(grid1, grid2, visited, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, int[][] visited, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return false;
        }
        if (grid2[i][j] == 0) {
            return true;
        }
        if (grid1[i][j] == 0) {
            return false;
        }
        if (visited[i][j] == 1) {
            return true;
        }
        visited[i][j] = 1;
        return dfs(grid1, grid2, visited, i - 1, j) && dfs(grid1, grid2, visited, i + 1, j) && dfs(grid1, grid2, visited, i, j - 1) && dfs(grid1, grid2, visited, i, j + 1);
    }
}