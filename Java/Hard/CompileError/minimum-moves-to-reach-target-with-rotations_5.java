class Solution {
    public int minimumMoves(int[][] grid) {
        
        int n = grid.length;
        int[][][] visited = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j][0] = visited[i][j][1] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], d = cur[2];
            if (r == n - 1 && c == n - 2 && d == 0) {
                return visited[r][c][d];
            }
            if (d == 0) {
                if (c + 1 < n && grid[r][c + 1] == 0) {
                    if (visited[r][c + 1][0] > visited[r][c][0] + 1) {
                        visited[r][c + 1][0] = visited[r][c][0] + 1;
                        queue.offer(new int[]{r, c + 1, 0});
                    }
                }
                if (r + 1 < n && grid[r + 1][c] == 0 && grid[r + 1][c + 1] == 0) {
                    if (visited[r + 1][c][1] > visited[r][c][0] + 1) {
                        visited[r + 1][c][1] = visited[r][c][0] + 1;
                        queue.offer(new int[]{r + 1, c, 1});
                    }
                }
            } else {
                if (r + 1 < n && grid[r + 1][c] == 0) {
                    if (visited[r + 1][c][1] > visited[r][c][1] + 1) {
                        visited[r + 1][c][1] = visited[r][c][1] + 1;
                        queue.offer(new int[]{r + 1, c, 1});
                    }
                }
                if (c + 1 < n && grid[r
    }
}