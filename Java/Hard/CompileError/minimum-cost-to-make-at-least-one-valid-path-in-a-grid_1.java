class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            int c = cost[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i], ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int nc = c + (grid[x][y] == i + 1 ? 0 : 1);
                    if (nc < cost[nx][ny]) {
                        cost[nx][ny] = nc;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}