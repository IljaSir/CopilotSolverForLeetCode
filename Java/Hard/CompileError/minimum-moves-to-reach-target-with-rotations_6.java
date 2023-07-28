class Solution {
    public int minimumMoves(int[][] grid) {
        
        int n = grid.length;
        int[][][] dist = new int[n][n][2];
        for (int i = 0; i < n; ++i)
            for (int j = 0; j < n; ++j)
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);

        Queue<int[]> queue = new LinkedList();
        queue.offer(new int[]{0, 0, 0});
        dist[0][0][0] = 0;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int r1 = node[0], c1 = node[1], k = node[2];
            int r2 = r1 + (k == 0 ? 0 : 1);
            int c2 = c1 + (k == 0 ? 1 : 0);
            int d = dist[r1][c1][k];
            if (r1 == n-1 && c1 == n-2 && k == 0) return d;
            if (r1 == n-2 && c1 == n-1 && k == 1) return d;

            // move right
            if (c2+1 < n && grid[r1][c2+1] == 0) {
                int nc1 = c1 + 1, nc2 = c2 + 1;
                int nk = k;
                if (dist[r1][nc1][nk] > d) {
                    dist[r1][nc1][nk] = d;
                    queue.offer(new int[]{r1, nc1, nk});
                }
            }

            // move down
            if (r2+1 < n && grid[r2+1][c1] == 0) {
                int nr1 = r1 + 1, nr2 = r2 + 1;
                int nk = k;
                if (dist[nr1][c1][nk] > d) {
                    dist[nr1][c1][nk] = d;
                    queue.offer(new int[]{nr1, c1, nk});
                }
            }

            // rotate clockwise
            if (k == 0 && r2+1 < n && grid[r2+1][c1] == 0 && grid[r2+1][c2] == 0) {
                int nr1 =
    }
}