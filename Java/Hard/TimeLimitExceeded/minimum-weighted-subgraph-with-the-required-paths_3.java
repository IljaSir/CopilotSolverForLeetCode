class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        long[][] dist = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Long.MAX_VALUE);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            dist[e[0]][e[1]] = Math.min(dist[e[0]][e[1]], e[2]);
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] < Long.MAX_VALUE && dist[k][j] < Long.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (dist[src1][i] < Long.MAX_VALUE && dist[src2][i] < Long.MAX_VALUE && dist[i][dest] < Long.MAX_VALUE) {
                ans = Math.min(ans, dist[src1][i] + dist[src2][i] + dist[i][dest]);
            }
        }
        return ans == Long.MAX_VALUE ? -1 : ans;
    }
}