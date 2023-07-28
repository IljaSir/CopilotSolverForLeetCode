class Solution {
    public int maxDistance(int[][] grid) {
        
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i, j});
                }
            }
        }
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 0) {
                    grid[nx][ny] = grid[x][y] + 1;
                    hasOcean = true;
                    queue.add(new int[] {nx, ny});
                }
            }
        }
        if (point == null || !hasOcean) {
            return -1;
        }
        return grid[point[0]][point[1]] - 1;
    }
}