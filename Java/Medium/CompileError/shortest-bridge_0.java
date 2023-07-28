class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        boolean found = false;
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j);
                    found = true;
                    break;
                }
            }
        }
        int res = 0;
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0];
                int y = cur[1];
                if (grid[x][y] == 2) {
                    return res - 1;
                }
                if (x > 0 && !visited[x - 1][y]) {
                    q.offer(new int[]{x - 1, y});
                    visited[x - 1][y] = true;
                }
                if (x < n - 1 && !visited[x + 1][y]) {
                    q.offer(new int[]{x + 1, y});
                    visited[x + 1][y] = true;
                }
                if (y > 0 && !visited[x][y - 1]) {
                    q.offer(new int[]{x, y - 1});
                    visited[x][y - 1] = true;
                }
                if (y < n - 1 && !visited[x][y + 1]) {
                    q.offer(new int[]{x, y + 1});
                    visited[x][y + 1] = true;
                }
            }
            res++;
        }
        return res;
    }
}