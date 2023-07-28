class Solution {
    public int swimInWater(int[][] grid) {
        
        if (grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int n = grid.length;
        int[][] d = new int[n][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < n; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        d[0][0] = grid[0][0];
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.add(new int[]{0, 0, grid[0][0]});
        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int x = top[0], y = top[1], t = top[2];
            if (x == n - 1 && y == n - 1) {
                return d[x][y];
            }
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && Math.max(t, grid[nx][ny]) < d[nx][ny]) {
                    d[nx][ny] = Math.max(t, grid[nx][ny]);
                    pq.add(new int[]{nx, ny, d[nx][ny]});
                }
            }
        }
        return -1;
    }
}