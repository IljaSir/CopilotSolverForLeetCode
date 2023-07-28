class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                adj[i][j] = i == j ? 0 : Integer.MAX_VALUE;
            }
        }
        for (int[] r : roads) {
            adj[r[0]][r[1]] = r[2];
            adj[r[1]][r[0]] = r[2];
        }
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;
        int[] ways = new int[n];
        ways[0] = 1;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int v = 0; v < n; v++) {
                if (!visited[v] && (u == -1 || dist[v] < dist[u])) {
                    u = v;
                }
            }
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (adj[u][v] != Integer.MAX_VALUE) {
                    if (dist[v] > dist[u] + adj[u][v]) {
                        dist[v] = dist[u] + adj[u][v];
                        ways[v] = ways[u];
                        ways[v] %= 1_000_000_007;
                    } else if (dist[v] == dist[u] + adj[u][v]) {
                        ways[v] += ways[u];
                        ways[v] %= 1_000_000_007;
                    }
                }
            }
        }
        return ways[n - 1];
    }
}