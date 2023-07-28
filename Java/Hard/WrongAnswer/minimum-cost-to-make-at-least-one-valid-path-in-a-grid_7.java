class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        cost[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            visited[x][y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0], ny = y + dirs[i][1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int newCost = cost[x][y] + (grid[x][y] == i + 1 ? 0 : 1);
                    if (newCost < cost[nx][ny]) {
                        cost[nx][ny] = newCost;
                        if (!visited[nx][ny]) {
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}