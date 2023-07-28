class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int[][] graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for(int[] road : roads) {
            int u = road[0], v = road[1], w = road[2];
            graph[u][v] = Math.min(graph[u][v], w);
            graph[v][u] = Math.min(graph[v][u], w);
        }
        int[] dist = new int[n];
        int[] ways = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        for(int i = 0; i < n; i++) {
            int u = -1;
            for(int j = 0; j < n; j++) {
                if(!visited[j] && (u == -1 || dist[j] < dist[u])) {
                    u = j;
                }
            }
            visited[u] = true;
            for(int v = 0; v < n; v++) {
                if(graph[u][v] != Integer.MAX_VALUE) {
                    if(dist[v] > dist[u] + graph[u][v]) {
                        dist[v] = dist[u] + graph[u][v];
                        ways[v] = ways[u];
                    } else if(dist[v] == dist[u] + graph[u][v]) {
                        ways[v] = (ways[v] + ways[u]) % 1000000007;
                    }
                }
            }
        }
        return ways[n - 1];
    }
}