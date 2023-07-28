class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }
        dist[0][0] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int[][] d = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : d) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] != 2) {
                    if (grid[x][y] == 1) {
                        dist[x][y] = 0;
                        queue.offer(new int[]{x, y});
                    } else {
                        if (dist[x][y] > dist[cur[0]][cur[1]] + 1) {
                            dist[x][y] = dist[cur[0]][cur[1]] + 1;
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dist[i][j]);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}