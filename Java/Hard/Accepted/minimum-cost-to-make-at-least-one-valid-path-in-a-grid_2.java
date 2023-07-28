class Solution {
    public int minCost(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] cost = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = Integer.MAX_VALUE;
            }
        }
        cost[0][0] = 0;
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dirs[i][0];
                int ny = y + dirs[i][1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                int c = grid[x][y] == i + 1 ? 0 : 1;
                if (cost[nx][ny] > cost[x][y] + c) {
                    cost[nx][ny] = cost[x][y] + c;
                    if (c == 0) q.addFirst(new int[]{nx, ny});
                    else q.addLast(new int[]{nx, ny});
                }
            }
        }
        return cost[m - 1][n - 1];
    }
}