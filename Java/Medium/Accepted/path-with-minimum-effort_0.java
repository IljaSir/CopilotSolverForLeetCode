class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[1];
            int y = cur[2];
            if (x == m - 1 && y == n - 1) {
                return dist[x][y];
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int d = Math.max(dist[x][y], Math.abs(heights[nx][ny] - heights[x][y]));
                if (d < dist[nx][ny]) {
                    dist[nx][ny] = d;
                    pq.offer(new int[]{d, nx, ny});
                }
            }
        }
        return -1;
    }
}