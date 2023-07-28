class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            if (found) break;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
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
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= n || grid[x][y] == 2) continue;
                    if (grid[x][y] == 1) return step;
                    grid[x][y] = 2;
                    queue.offer(new int[]{x, y});
                }
            }
            step++;
        }
        return -1;
    }
}