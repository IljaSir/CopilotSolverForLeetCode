class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int x = top[1];
            int y = top[2];
            if (d > dist[x][y]) {
                continue;
            }
            if (x == n - 1 && y == m - 1) {
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    int nd = Math.max(d, Math.abs(heights[nx][ny] - heights[x][y]));
                    if (nd < dist[nx][ny]) {
                        dist[nx][ny] = nd;
                        pq.add(new int[]{nd, nx, ny});
                    }
                }
            }
        }
        return dist[n - 1][m - 1];
    }
}