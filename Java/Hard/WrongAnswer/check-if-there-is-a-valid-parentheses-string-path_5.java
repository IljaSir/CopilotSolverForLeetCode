class Solution {
    public boolean hasValidPath(char[][] grid) {
        
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int n = grid.length, m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int dir = -1;
            if (grid[r][c] == '/') {
                dir = (r + c) % 2 == 0 ? 3 : 1;
            } else if (grid[r][c] == '\\') {
                dir = (r + c) % 2 == 0 ? 1 : 3;
            } else {
                dir = 0;
            }
            for (int i = dir; i <= dir + 1; i++) {
                int nr = r + dirs[i % 4][0], nc = c + dirs[i % 4][1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !visited[nr][nc]) {
                    if (grid[nr][nc] == '/' && (i % 4 == 1 || i % 4 == 2)) {
                        continue;
                    }
                    if (grid[nr][nc] == '\\' && (i % 4 == 0 || i % 4 == 3)) {
                        continue;
                    }
                    if (grid[nr][nc] == '(' && (i % 4 == 3 || i % 4 == 2)) {
                        continue;
                    }
                    if (grid[nr][nc] == ')' && (i % 4 == 1 || i % 4 == 0)) {
                        continue;
                    }
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return visited[n - 1][m - 1];
    }
}