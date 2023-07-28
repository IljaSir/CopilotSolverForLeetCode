class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i, heightMap[0][i]});
            pq.offer(new int[]{m - 1, i, heightMap[m - 1][i]});
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int x = cur[0];
            int y = cur[1];
            int h = cur[2];
            int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                res += Math.max(0, h - heightMap[nx][ny]);
                pq.offer(new int[]{nx, ny, Math.max(h, heightMap[nx][ny])});
            }
        }
        return res;
    }
}