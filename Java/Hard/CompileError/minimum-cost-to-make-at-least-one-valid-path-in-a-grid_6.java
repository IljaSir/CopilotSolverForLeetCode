class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int cost = dist[x][y];
                    if (grid[x][y] != i + 1) {
                        cost++;
                    }
                    if (cost < dist[nx][ny]) {
                        dist[nx][ny] = cost;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}