class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] visited = new int[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = 1;
            visited[i][n - 1] = 1;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = 1;
            visited[m - 1][j] = 1;
        }
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == 1) {
                    continue;
                }
                visited[x][y] = 1;
                if (cur[2] > heightMap[x][y]) {
                    res += cur[2] - heightMap[x][y];
                }
                pq.offer(new int[]{x, y, Math.max(cur[2], heightMap[x][y])});
            }
        }
        return res;
    }
}