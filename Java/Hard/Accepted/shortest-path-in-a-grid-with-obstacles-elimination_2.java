class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        boolean[][][] visited = new boolean[m][n][k+1];
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k});
        visited[0][0][k] = true;
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                int obs = cur[2];
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n) {
                        continue;
                    }
                    if (nx == m - 1 && ny == n - 1) {
                        return steps + 1;
                    }
                    if (grid[nx][ny] == 1) {
                        if (obs > 0 && !visited[nx][ny][obs-1]) {
                            queue.offer(new int[]{nx, ny, obs-1});
                            visited[nx][ny][obs-1] = true;
                        }
                    } else {
                        if (!visited[nx][ny][obs]) {
                            queue.offer(new int[]{nx, ny, obs});
                            visited[nx][ny][obs] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}