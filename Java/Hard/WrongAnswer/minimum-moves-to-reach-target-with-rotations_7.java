class Solution {
    public int minimumMoves(int[][] grid) {
        
        int N = grid.length;
        int[][][] visited = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j][0] = visited[i][j][1] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 0});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int d = curr[2];
            int step = curr[3];
            if (x == N - 1 && y == N - 2 && d == 0) {
                return step;
            }
            if (visited[x][y][d] <= step) {
                continue;
            }
            visited[x][y][d] = step;
            if (d == 0) {
                if (y + 1 < N && grid[x][y + 1] == 0) {
                    queue.offer(new int[]{x, y + 1, 0, step + 1});
                }
                if (x + 1 < N && grid[x + 1][y] == 0 && grid[x + 1][y + 1] == 0) {
                    queue.offer(new int[]{x, y, 1, step + 1});
                }
            } else {
                if (x + 1 < N && grid[x + 1][y] == 0) {
                    queue.offer(new int[]{x + 1, y, 1, step + 1});
                }
                if (y + 1 < N && grid[x][y + 1] == 0 && grid[x + 1][y + 1] == 0) {
                    queue.offer(new int[]{x, y, 0, step + 1});
                }
            }
        }
        return -1;
    }
}