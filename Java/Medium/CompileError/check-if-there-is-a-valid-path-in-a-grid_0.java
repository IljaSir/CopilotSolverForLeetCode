class Solution {
    public boolean hasValidPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        return dfs(grid, 0, 0, visited);
    }
    
    private boolean dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i == m-1 && j == n-1) {
            return true;
        }
        
        int[] dx = new int[] {0, 0, -1, 1};
        int[] dy = new int[] {-1, 1, 0, 0};
        for (int k = 0; k < dx.length; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                continue;
            }
            if (grid[i][j] == 1 && (k == 0 || k == 1)) {
                continue;
            }
            if (grid[i][j] == 2 && (k == 2 || k == 3)) {
                continue;
            }
            if (grid[i][j] == 3 && (k == 0 || k == 3)) {
                continue;
            }
            if (grid[i][j] == 4 && (k == 1 || k == 3)) {
                continue;
            }
            if (grid[i][j] == 5 && (k == 0 || k == 2)) {
                continue;
            }
            if (grid[i][j] == 6 && (k == 1 || k == 2)) {
                continue;
            }
            if (grid[nx][ny] == 1 && (k == 0 || k == 1)) {
                continue;
            }
            if (grid[nx][ny] == 2 && (k == 2 || k == 3)) {
                continue;
            }
            if (grid[nx][ny] == 3 && (k == 2 || k == 1)) {
                continue;
            }
            if (grid[nx][ny] == 4 && (
    }
}