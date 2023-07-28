class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        int[][] dist = new int[n][n];
        boolean[][] seen = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }
        if (q.size() == 0 || q.size() == n * n) {
            return -1;
        }
        int ans = -1;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            for (int[] d: new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}}) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !seen[nx][ny]) {
                    dist[nx][ny] = dist[x][y] + 1;
                    ans = Math.max(ans, dist[nx][ny]);
                    q.add(new int[]{nx, ny});
                    seen[nx][ny] = true;
                }
            }
        }
        return ans;
    }
}