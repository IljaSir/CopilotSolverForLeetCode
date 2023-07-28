class Solution {
    public int maximumMinutes(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] time = new int[m][n];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                    time[i][j] = 1;
                }
            }
        }
        int res = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int nx = cur[0] + dir[0], ny = cur[1] + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] == 0 && time[nx][ny] == 0) {
                    q.offer(new int[]{nx, ny});
                    time[nx][ny] = time[cur[0]][cur[1]] + 1;
                    res = Math.max(res, time[nx][ny]);
                }
            }
        }
        return res - 1;
    }
}