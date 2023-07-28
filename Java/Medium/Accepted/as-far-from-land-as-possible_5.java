class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }
        if (q.size() == 0 || q.size() == n * m) {
            return -1;
        }
        int res = -1;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 0) {
                    continue;
                }
                grid[x][y] = grid[cur[0]][cur[1]] + 1;
                res = Math.max(res, grid[x][y] - 1);
                q.offer(new int[]{x, y});
            }
        }
        return res;
    }
}