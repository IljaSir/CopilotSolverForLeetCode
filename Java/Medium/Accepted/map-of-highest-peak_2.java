class Solution {
    public int[][] highestPeak(int[][] isWater) {
        
        int m = isWater.length;
        int n = isWater[0].length;
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i][j] = isWater[i][j] == 1 ? 0 : -1;
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int[] d : dir) {
                int x = cur[0] + d[0];
                int y = cur[1] + d[1];
                if (x < 0 || x >= m || y < 0 || y >= n || res[x][y] != -1) {
                    continue;
                }
                res[x][y] = res[cur[0]][cur[1]] + 1;
                queue.add(new int[]{x, y});
            }
        }
        return res;
    }
}