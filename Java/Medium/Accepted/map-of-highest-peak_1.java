class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] height = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                } else {
                    height[i][j] = -1;
                }
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] dir : dirs) {
                int nextX = cur[0] + dir[0];
                int nextY = cur[1] + dir[1];
                if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && height[nextX][nextY] == -1) {
                    height[nextX][nextY] = height[cur[0]][cur[1]] + 1;
                    queue.add(new int[]{nextX, nextY});
                }
            }
        }
        return height;
    }
}