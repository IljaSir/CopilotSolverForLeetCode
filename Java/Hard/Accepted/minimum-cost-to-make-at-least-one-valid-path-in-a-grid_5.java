class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int c = cur[2];
            if (x == m - 1 && y == n - 1) {
                return c;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nc = c + (grid[x][y] == i + 1 ? 0 : 1);
                    if (nc < cost[nx][ny]) {
                        cost[nx][ny] = nc;
                        pq.offer(new int[]{nx, ny, nc});
                    }
                }
            }
        }
        return -1;
    }
}