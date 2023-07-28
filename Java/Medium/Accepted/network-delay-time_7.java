class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[][] graph = new int[n][n];
        for (int[] g : graph)
            Arrays.fill(g, -1);
        for (int[] time : times)
            graph[time[0] - 1][time[1] - 1] = time[2];
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || dist[j] < dist[u]))
                    u = j;
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (graph[u][v] != -1 && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }
        int ans = Arrays.stream(dist).max().getAsInt();
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}