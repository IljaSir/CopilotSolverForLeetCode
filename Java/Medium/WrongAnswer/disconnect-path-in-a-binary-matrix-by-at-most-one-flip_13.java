class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] visited = new int[m][n];
        int[][] dirs = {{0, 1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            for (int[] dir : dirs) {
                int x = pos[0] + dir[0];
                int y = pos[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1 && visited[x][y] == 0) {
                    visited[x][y] = 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        if (visited[m - 1][n - 1] == 1) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0 && visited[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean disconnectPath(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {1, 0}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    grid[i][j] = 1;
                    if (isPossibleToCutPath(grid)) {
                        return true;
                    }
                    grid[i][j] = 0;
                }
            }
        }
        return false;
    }
}