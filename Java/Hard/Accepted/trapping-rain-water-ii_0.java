class Solution {
    public int trapRainWater(int[][] heightMap) {
        
        int m = heightMap.length, n = heightMap[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{i, 0, heightMap[i][0]});
            pq.offer(new int[]{i, n - 1, heightMap[i][n - 1]});
            visited[i][0] = true;
            visited[i][n - 1] = true;
        }
        for (int j = 1; j < n - 1; j++) {
            pq.offer(new int[]{0, j, heightMap[0][j]});
            pq.offer(new int[]{m - 1, j, heightMap[m - 1][j]});
            visited[0][j] = true;
            visited[m - 1][j] = true;
        }
        int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int res = 0;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            for (int[] dir : dirs) {
                int i = cur[0] + dir[0], j = cur[1] + dir[1];
                if (i >= 0 && i < m && j >= 0 && j < n && !visited[i][j]) {
                    visited[i][j] = true;
                    res += Math.max(0, cur[2] - heightMap[i][j]);
                    pq.offer(new int[]{i, j, Math.max(cur[2], heightMap[i][j])});
                }
            }
        }
        return res;
    }
}