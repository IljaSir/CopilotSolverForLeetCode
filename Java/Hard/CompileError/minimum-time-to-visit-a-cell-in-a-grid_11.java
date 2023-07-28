class Solution {
    public int minimumTime(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] times = new int[m][n];
        for (int[] row : times) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        times[0][0] = 0;
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
                    int time = Math.max(times[x][y], grid[nx][ny]);
                    if (time < times[nx]ny]) {
                        ties[nx][ny]= time;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        return times[m - 1][n  1];
    }
}