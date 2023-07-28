class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1,0}, {0,1}};
        if (grid[0][0] == 0 || grid[m-1][n-1] == 0) {
            return false;
        }
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }
                if (grid[nr][nc] == 1 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        if (visited[m-1][n-1]) {
            return false;
        }
        return true;
    }
    public boolean disconnectPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                grid[i][j] = 0;
                if (isPossibleToCutPath(grid)) {
                    return true;
                }
                grid[i][j] = 1;
            }
        }
        return false;
                return false;
            }
        }
        for (int i = 1; i < n - 1; i++) {
            if (grid[m - 1][i] == 0 && grid[m - 2][i - 1] == 0 && grid[m - 2][i + 1] == 0) {
                return false;
            }
        }
        return true;
    }
}