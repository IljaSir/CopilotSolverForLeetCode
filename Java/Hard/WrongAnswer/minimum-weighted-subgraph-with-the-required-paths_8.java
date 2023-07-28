class Solution {
    public long minimumWeight(int n, int[][] edges, int src1, int src2, int dest) {
        
        long[][] dist = new long[n][n];
        for (long[] d : dist) {
            Arrays.fill(d, Long.MAX_VALUE);
        }
        for (int[] e : edges) {
            dist[e[0]][e[1]] = e[2];
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] != Long.MAX_VALUE && dist[k][j] != Long.MAX_VALUE) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
        if (dist[src1][dest] == Long.MAX_VALUE || dist[src2][dest] == Long.MAX_VALUE) {
            return -1;
        }
        long min = dist[src1][dest] + dist[src2][dest];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dist[src1][i] != Long.MAX_VALUE && dist[i][j] != Long.MAX_VALUE && dist[j][dest] != Long.MAX_VALUE
                        && dist[src2][i] != Long.MAX_VALUE && dist[j][src2] != Long.MAX_VALUE) {
                    min = Math.min(min, dist[src1][i] + dist[i][j] + dist[j][dest] + dist[src2][i] + dist[j][src2]);
                }
            }
        }
        return min;
    }
}