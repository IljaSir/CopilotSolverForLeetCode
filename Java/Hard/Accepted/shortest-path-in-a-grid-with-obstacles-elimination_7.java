class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        boolean[][][] visited = new boolean[m][n][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                int obs = cur[2];
                if (r == m - 1 && c == n - 1) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    int nr = r + dir[j][0];
                    int nc = c + dir[j][1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                        int nobs = obs + grid[nr][nc];
                        if (nobs <= k && !visited[nr][nc][nobs]) {
                            queue.offer(new int[]{nr, nc, nobs});
                            visited[nr][nc][nobs] = true;
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
}