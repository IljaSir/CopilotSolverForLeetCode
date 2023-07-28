class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length, n = grid[0].length;
        if (m == 1 && n == 1) return 0;
        if (k >= m + n - 3) return m + n - 2;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, k});
        boolean[][][] visited = new boolean[m][n][k + 1];
        visited[0][0][k] = true;
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                int x = cur[0], y = cur[1], remain = cur[2];
                for (int[] dir : dirs) {
                    int nx = x + dir[0], ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                    if (nx == m - 1 && ny == n - 1) return step + 1;
                    if (grid[nx][ny] == 0 && !visited[nx][ny][remain]) {
                        q.offer(new int[]{nx, ny, remain});
                        visited[nx][ny][remain] = true;
                    } else if (grid[nx][ny] == 1 && remain > 0 && !visited[nx][ny][remain - 1]) {
                        q.offer(new int[]{nx, ny, remain - 1});
                        visited[nx][ny][remain - 1] = true;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}