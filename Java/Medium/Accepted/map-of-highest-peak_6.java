class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] res = new int[m][n];
        for (int[] row : res) {
            Arrays.fill(row, -1);
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    res[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] direction : directions) {
                int x = cell[0] + direction[0];
                int y = cell[1] + direction[1];
                if (x >= 0 && x < m && y >= 0 && y < n && res[x][y] == -1) {
                    res[x][y] = res[cell[0]][cell[1]] + 1;
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return res;
    }
}