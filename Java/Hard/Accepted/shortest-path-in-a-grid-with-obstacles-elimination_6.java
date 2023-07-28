class Solution {
    public int shortestPath(int[][] grid, int k) {
        
        int m = grid.length;
        int n = grid[0].length;
        if (m == 1 && n == 1) {
            return 0;
        }
        int[][][] visited = new int[m][n][k + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(visited[i][j], Integer.MAX_VALUE);
            }
        }
        visited[0][0][0] = 0;
        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            steps++;
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int nextX = cur[0] + dir[0];
                    int nextY = cur[1] + dir[1];
                    if (nextX < 0 || nextX >= m || nextY < 0 || nextY >= n) {
                        continue;
                    }
                    int nextK = cur[2] + grid[nextX][nextY];
                    if (nextK > k || steps >= visited[nextX][nextY][nextK]) {
                        continue;
                    }
                    if (nextX == m - 1 && nextY == n - 1) {
                        return steps;
                    }
                    visited[nextX][nextY][nextK] = steps;
                    queue.offer(new int[] {nextX, nextY, nextK});
                }
            }
        }
        return -1;
    }
}