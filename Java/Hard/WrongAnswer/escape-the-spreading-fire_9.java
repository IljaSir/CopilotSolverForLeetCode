class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int[][] dist = new int[m][n];
        int res = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    dist[i][j] = 1;
                }
            }
        }
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0 || dist[x][y] != 0) {
                    continue;
                }
                dist[x][y] = dist[cur[0]][cur[1]] + 1;
                q.offer(new int[]{x, y});
            }
        }
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == 0) {
                    res = Math.max(res, dist[i][j] - 1);
                }
            }
        }
        return res;
    }
}