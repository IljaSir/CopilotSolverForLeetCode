class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dist[i][j] = dist[j][i] = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
            }
        }
        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        boolean[] visited = new boolean[n];
        int res = 0;
        minDist[0] = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || minDist[j] < minDist[u])) {
                    u = j;
                }
            }
            visited[u] = true;
            res += minDist[u];
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    minDist[v] = Math.min(minDist[v], dist[u][v]);
                }
            }
        }
        return res;
    }
}