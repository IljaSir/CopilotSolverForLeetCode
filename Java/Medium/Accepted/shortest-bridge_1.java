class Solution {
    public int shortestBridge(int[][] grid) {
        
        Queue<int[]> q = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < grid.length; i++) {
            if (found) break;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, q);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cur = q.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 2) continue;
                    if (grid[x][y] == 1) return step;
                    grid[x][y] = 2;
                    q.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
    
    private void dfs(int[][] grid, int i, int j, Queue<int[]> q) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = 2;
        q.offer(new int[]{i, j});
        dfs(grid, i + 1, j, q);
        dfs(grid, i - 1, j, q);
        dfs(grid, i, j + 1, q);
        dfs(grid, i, j - 1, q);
    }
}