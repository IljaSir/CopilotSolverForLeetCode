class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        pq.offer(new int[]{0, 0, 0});
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int x = curr[0];
            int y = curr[1];
            int d = curr[2];
            for (int[] dir: dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int nd = Math.max(d, Math.abs(heights[nx][ny] - heights[x][y]));
                if (nd < dist[nx][ny]) {
                    dist[nx][ny] = nd;
                    pq.offer(new int[]{nx, ny, nd});
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}