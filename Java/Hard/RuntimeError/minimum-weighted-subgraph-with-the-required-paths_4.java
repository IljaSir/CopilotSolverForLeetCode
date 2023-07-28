class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
        long[] dist1 = dist[src1];
        long[] dist2 = dist[src2];
        long[] dist3 = dist[dest];
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist1[i] != Long.MAX_VALUE && dist2[i] != Long.MAX_VALUE && dist3[i] != Long.MAX_VALUE) {
                ans = Math.min(ans, dist1[i] + dist2[i] + dist3[i]);
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}