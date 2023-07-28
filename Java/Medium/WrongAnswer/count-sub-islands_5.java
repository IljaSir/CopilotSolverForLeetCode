class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int m = grid1.length;
        int n = grid1[0].length;
        boolean[][] visited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && !visited[i][j]) {
                    if (dfs(grid1, grid2, visited, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    
    private boolean dfs(int[][] grid1, int[][] grid2, boolean[][] visited, int row, int col) {
        int m = grid1.length;
        int n = grid1[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return true;
        }
        visited[row][col] = true;
        if (grid2[row][col] == 0) {
            return false;
        }
        boolean up = dfs(grid1, grid2, visited, row - 1, col);
        boolean down = dfs(grid1, grid2, visited, row + 1, col);
        boolean left = dfs(grid1, grid2, visited, row, col - 1);
        boolean right = dfs(grid1, grid2, visited, row, col + 1);
        return up && down && left && right && grid1[row][col] == 1;
    }
}