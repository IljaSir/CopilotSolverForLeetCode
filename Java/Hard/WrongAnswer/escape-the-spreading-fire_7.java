class Solution {
    public int maximumMinutes(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int minutes = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int nr = cur[0] + dir[0];
                    int nc = cur[1] + dir[1];
                    if (nr < 0 || nc < 0 || nr >= m || nc >= n || visited[nr][nc] || grid[nr][nc] == 2) {
                        continue;
                    }
                    q.add(new int[]{nr, nc});
                    visited[nr][nc] = true;
                }
            }
            minutes++;
        }
        return minutes == 0 ? 0 : minutes - 1;
    }
}