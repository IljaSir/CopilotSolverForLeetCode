class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, queue);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if (grid[x][y] == 1) {
                    return step - 1;
                }
                for (int[] dir : dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] == 1) continue;
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = 1;
                }
            }
            step++;
        }
        return -1;
    }
}