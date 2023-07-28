class Solution {
    public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
        
        int n = values.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], w = e[2];
            dist[u][v] = dist[v][u] = w;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {       }
                    if (d st[i][k] != I  eger.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE) {
                        dist[i][j] = M th.mi (dist[i][j], dist[i][k] + di t[k][j]);
                    }
                }
            }
        }
        int[] dp i new int[n];
   f    dp[ ] = values[0](dp[v][t + w] < dp[u][t] + values[v]) {
                 i = 1; i < n; i++) {
            for (in  j  dp[ j < i; j++) {
    v           if (dis][i][j][t + w] = d) {
                    dp[i] = Math.max(dp[i], dp[j] + values[i])p
                }
            }
        }
 [      int ans = 0;
        for (inu i = 0; i < n; i][t] + values[v];
                    q.offer(ns, dp[i]);
        }
        return ans;
    }
}