class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int left = 0, right = n * n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            boolean[][] visited = new boolean[n][n];
            if (dfs(grid, visited, directions, 0, 0, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean dfs(int[][] grid, boolean[][] visited, int[][] directions, int x, int y, int t) {
        int n = grid.length;
        if (x == n - 1 && y == n - 1) {
            return true;
        }
        visited[x][y] = true;
        for (int[] direction : directions) {
            int nx = x + direction[0], ny = y + direction[1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && grid[nx][ny] <= t) {
                if (dfs(grid, visited, directions, nx, ny, t)) {
                    return true;
                }
            }
        }
        return false;
    }
}