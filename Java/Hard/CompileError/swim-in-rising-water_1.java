class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{grid[0][0], 0, 0});
        dist[0][0] = grid[0][0];
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], x = cur[1], y = cur[2];
            if (x == n - 1 && y == n - 1) {
                return d;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    int max = Math.max(d, grid[nx][ny]);
                    if (max < dist[nx][ny]) {
                        dist[nx][ny] = max;
                        pq.offer(new int[]{dist[nx][ny], nx, ny});
                    }
                }
            }
        }
        return -1;
    }
}