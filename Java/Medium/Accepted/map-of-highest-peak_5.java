class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int m = isWater.length, n = isWater[0].length;
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
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    q.add(new int[] {i, j});
                }
            }
        }
        int[][] dir = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0], y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || height[x][y] != -1) {
                    continue;
                }
                height[x][y] = height[cur[0]][cur[1]] + 1;
                q.add(new int[] {x, y});
            }
        }
        return height;
    }
}