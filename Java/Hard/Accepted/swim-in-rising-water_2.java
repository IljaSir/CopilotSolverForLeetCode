class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        int[][] times = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(times[i], Integer.MAX_VALUE);
        }
        times[0][0] = grid[0][0];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0], c = cur[1], t = cur[2];
            if (r == n - 1 && c == n - 1) {
                return t;
            }
            for (int[] d : dir) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nt = Math.max(t, grid[nr][nc]);
                    if (nt < times[nr][nc]) {
                        times[nr][nc] = nt;
                        pq.add(new int[]{nr, nc, nt});
                    }
                }
            }
        }
        return -1;
    }
}