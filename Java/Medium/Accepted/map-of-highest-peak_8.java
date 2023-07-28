class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] heights = new int[m][n];
        for (int[] row : heights) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    heights[i][j] = 0;
                }
            }
        }
        int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x < m && y >= 0 && y < n && heights[x][y] == -1) {
                    heights[x][y] = heights[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return heights;
    }
}