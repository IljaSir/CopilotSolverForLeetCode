class Solution {
    public int minCost(int[][] grid) {
        
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                    continue;
                }
                int ncost = cost[x][y];
                if (grid[x][y] != i + 1) {
                    ncost++;
                }
                if (ncost < cost[nx][ny]) {
                    cost[nx][ny] = ncost;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}