class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        if (heightMap.length == 0) return 0;
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            visited[i][0] = true;
            visited[i][n - 1] = true;
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
        }
        for (int j = 1; j < n - 1; j++) {
            visited[0][j] = true;
            visited[m - 1][j] = true;
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
        }
        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cell = pq.poll();
            for (int i = 0; i < 4; i++) {
                int x = cell[0] + dx[i];
                int y = cell[1] + dy[i];
                if (x >= 0 && x < m && y >= 0 && y < n && !visited[x][y]) {
                    visited[x][y] = true;
                    res += Math.max(0, cell[2] - heightMap[x][y]);
                    pq.offer(new int[]{x, y, Math.max(heightMap[x][y], cell[2])});
                }
            }
        }
        return res;
    }
}