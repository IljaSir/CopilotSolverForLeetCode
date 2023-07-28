class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = grid[0][0];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[] {0, 0, grid[0][0]});
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0], y = cur[1], d = cur[2];
            if (x == n - 1 && y == n - 1) {
                return d;
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int nd = Math.max(d, grid[nx][ny]);
                    if (nd < dist[nx][ny]) {
                        dist[nx][ny] = nd;
                        pq.offer(new int[] {nx, ny, nd});
                    }
                }
            }
        }
        return -1;
    }
}