class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        boolean found = false;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, visited, q);
                    found = true;
                    break;
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y]) continue;
                    if (grid[x][y] == 1) return step;
                    visited[x][y] = true;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
}