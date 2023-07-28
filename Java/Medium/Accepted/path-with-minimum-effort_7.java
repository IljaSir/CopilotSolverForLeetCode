class Solution {
    public int minimumEffortPath(int[][] heights) {
        
        int n = heights.length;
        int m = heights[0].length;
        int[][] dist = new int[n][m];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] {0, 0, 0});
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], r = cur[1], c = cur[2];
            if (r == n - 1 && c == m - 1) {
                return d;
            }
            for (int[] dir : dirs) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    int nd = Math.max(d, Math.abs(heights[nr][nc] - heights[r][c]));
                    if (nd < dist[nr][nc]) {
                        dist[nr][nc] = nd;
                        pq.offer(new int[] {nd, nr, nc});
                    }
                }
            }
        }
        return -1;
    }
}