class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = dist[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int res = 0;
        pq.offer(new int[]{0, 0});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], i = cur[1];
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            res += d;
            for (int j = 0; j < n; j++) {
                if (!visited[j]) {
                    pq.offer(new int[]{dist[i][j], j});
                }
            }
        }
        return res;
    }
}