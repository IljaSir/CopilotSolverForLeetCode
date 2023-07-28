class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            for (int i = 0; i < 4; ++i) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int ncost = cost[x][y];
                    if (grid[x][y] != i + 1) {
                        ncost++;
                    }
                    if (ncost < cost[nx][ny]) {
                        cost[nx][ny] = ncost;
                        q.offer(new int[] {nx, ny});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}