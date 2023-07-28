class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int mod = (int)1e9 + 7;
        long[][] dist = new long[n][n];
        for (long[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (int[] r : roads) {
            dist[r[0]][r[1]] = r[2];
            dist[r[1]][r[0]] = r[2];
        }
        for (int i = 0; i < n; i++) {
            dist[i][i] = 0;
        }
        long[][] count = new long[n][n];
        for (long[] c : count) {
            Arrays.fill(c, 0);
        }
        for (int i = 0; i < n; i++) {
            count[i][i] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] == Integer.MAX_VALUE || dist[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        count[i][j] = count[i][k] * count[k][j] % mod;
                    } else if (dist[i][j] == dist[i][k] + dist[k][j]) {
                        count[i][j] = (count[i][j] + count[i][k] * count[k][j] % mod) % mod;
                    }
                }
            }
        }
        return (int)count[0][n - 1];
    }
}