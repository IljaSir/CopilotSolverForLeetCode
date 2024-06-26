class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        int[][] g = new int[n][n];
        for (int[] e : edges) {
            g[e[0]][e[1]] = e[2];
            g[e[1]][e[0]] = e[2];
        }
        int[] q = new int[n];
        int[] t = new int[n];
        boolean[] visited = new boolean[n];
        Arrays.fill(q, -1);
        q[0] = values[0];
        t[0] = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int u = -1;
            for (int j = 0; j < n; j++) {
                if (!visited[j] && (u == -1 || t[j] < t[u])) {
                    u = j;
                }
            }
            if (t[u] > maxTime) {
                break;
            }
            ans = Math.max(ans, q[u]);
            visited[u] = true;
            for (int v = 0; v < n; v++) {
                if (g[u][v] > 0) {
                    if (q[v] < q[u] + values[v]) {
                        q[v] = q[u] + values[v];
                        t[v] = t[u] + g[u][v];
                    } else if (q[v] == q[u] + values[v]) {
                        t[v] = Math.min(t[v], t[u] + g[u][v]);
                    }
                }
            }
        }
        return ans;
    }
}