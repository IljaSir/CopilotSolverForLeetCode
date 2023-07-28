class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] d = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, d, q);
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
                for (int j = 0; j < 4; j++) {
                    int x = cur[0] + d[j][0];
                    int y = cur[1] + d[j][1];
                    if (x < 0 || x >= n || y < 0 || y >= m || visited[x][y] == 1) {
                        continue;
                    }
                    if (grid[x][y] == 1) {
                        return step;
                    }
                    visited[x][y] = 1;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return step;
    }

    private void dfs(int[][] grid, int[][] visited, int i, int j, int[][] d, Queue<int[]> q) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == 1 || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = 1;
        q.offer(new int[]{i, j});
        for (int k = 0; k < 4; k++) {
            dfs(grid, visited, i + d[k][0], j + d[k][1], d, q);
        }
    }
}