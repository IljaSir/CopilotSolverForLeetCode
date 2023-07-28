class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k - 1] = 0;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int v = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (v == -1 || dist[j] < dist[v])) {
                    v = j;
                }
            }
            if (dist[v] == Integer.MAX_VALUE) {
                break;
            }
            visited[v] = true;
            for (int j = 0; j < n; j++) {
                if (graph[v][j] != Integer.MAX_VALUE) {
                    dist[j] = Math.min(dist[j], dist[v] + graph[v][j]);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dist[i]);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}