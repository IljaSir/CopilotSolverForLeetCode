class Solution {
    public int minCostConnectPoints(int[][] points) {
        
        int n = points.length;
        int[] dist = new int[n];
        boolean[] visited = new boolean[n];
        int res = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            res += dist[u];
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (!visited[v]) {
                    dist[v] = Math.min(dist[v], Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]));
                }
            }
        }
        return res;
    }
}