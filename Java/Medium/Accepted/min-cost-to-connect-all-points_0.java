class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int d = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                dist[i][j] = dist[j][i] = d;
            }
        }
        
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[0] = 0;
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && (u == -1 || minDist[u] > minDist[v])) {
                    u = v;
                }
            }
            res += minDist[u];
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && dist[u][v] < minDist[v]) {
                    minDist[v] = dist[u][v];
                }
            }
        }
        return res;
    }
}