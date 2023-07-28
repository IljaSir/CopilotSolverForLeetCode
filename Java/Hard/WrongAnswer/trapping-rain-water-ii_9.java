class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] height = new int[m][n];
        int[][] visited = new int[m][n];
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = 1;
            visited[i][n - 1] = 1;
        }
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{0, i, heightMap[0][i]});
            pq.offer(new int[]{m - 1, i, heightMap[m - 1][i]});
            visited[0][i] = 1;
            visited[m - 1][i] = 1;
        }
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] == 1) {
                    continue;
                }
                visited[x][y] = 1;
                height[x][y] = Math.max(height[x][y], Math.max(height[cur[0]][cur[1]], heightMap[x][y]));
                ans += height[x][y] - heightMap[x][y];
                pq.offer(new int[]{x, y, height[x][y]});
            }
        }
        return ans;
    }
}