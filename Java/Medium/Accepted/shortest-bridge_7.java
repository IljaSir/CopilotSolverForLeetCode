class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        boolean found = false;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited, q);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && !visited[x][y]) {
                        if (grid[x][y] == 1) {
                            return step;
                        }
                        visited[x][y] = true;
                        q.offer(new int[]{x, y});
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, Queue<int[]> q) {
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || i >= n || j < 0 || j >= m || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        q.offer(new int[]{i, j});
        dfs(grid, i - 1, j, visited, q);
        dfs(grid, i + 1, j, visited, q);
        dfs(grid, i, j - 1, visited, q);
        dfs(grid, i, j + 1, visited, q);
    }
}