class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int[][] visited = new int[n][m];
        int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, visited, i, j, queue);
                    found = true;
                    break;
                }
            }
            if (found) {
                break;
            }
        }
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                if (grid[cur[0]][cur[1]] == 1) {
                    return level - 1;
                }
                for (int[] direction : directions) {
                    int x = cur[0] + direction[0];
                    int y = cur[1] + direction[1];
                    if (x >= 0 && x < n && y >= 0 && y < m && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
            level++;
        }
        return -1;
    }
    
    private void dfs(int[][] grid, int[][] visited, int x, int y, Queue<int[]> queue) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == 0 || visited[x][y] == 1) {
            return;
        }
        visited[x][y] = 1;
        queue.offer(new int[]{x, y});
        dfs(grid, visited, x + 1, y, queue);
        dfs(grid, visited, x - 1, y, queue);
        dfs(grid, visited, x, y + 1, queue);
        dfs(grid, visited, x, y - 1, queue);
    }
}