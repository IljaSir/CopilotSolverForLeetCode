class Solution {
    public int minScore(int n, int[][] roads) {
        
        int[][] graph = new int[n][n];
        for (int[] r : roads) {
            int u = r[0] - 1;
            int v = r[1] - 1;
            int w = r[2];
            graph[u][v] = graph[v][u] = w;
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] > 0) {
                    dist[v] = Math.min(dist[v], Math.max(dist[u], graph[u][v]));
                }
            }
        }
        return dist[n - 1];
    }
}