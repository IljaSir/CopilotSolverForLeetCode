class Solution {
    public int minimumObstacles(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            for (int[] dir : dirs) {
                int x = i + dir[0], y = j + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n)
                    continue;
                if (grid[x][y] == 1) {
                    if (dist[i][j] + 1 < dist[x][y]) {
                        dist[x][y] = dist[i][j] + 1;
                        q.offer(new int[]{x, y});
                    }
                } else {
                    if (dist[i][j] < dist[x][y]) {
                        dist[x][y] = dist[i][j];
                        q.offerFirst(new int[]{x, y});
                    }
                }
            }
        }
        return dist[m - 1][n - 1];
    }
}