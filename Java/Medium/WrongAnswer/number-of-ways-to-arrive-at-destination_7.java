class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int MOD = 1_000_000_007;
        long[][] dist = new long[n][n];
        int[][] cnt = new int[n][n];
        for (long[] row: dist)
            Arrays.fill(row, Long.MAX_VALUE / 2);
        for (int[] row: cnt)
            Arrays.fill(row, 0);
        for (int[] e: roads) {
            int x = e[0], y = e[1], t = e[2];
            dist[x][y] = dist[y][x] = t;
            cnt[x][y] = cnt[y][x] = 1;
        }
        for (int i = 0; i < n; ++i) {
            dist[i][i] = 0;
            cnt[i][i] = 1;
        }

        for (int k = 0; k < n; ++k)
            for (int i = 0; i < n; ++i)
                for (int j = 0; j < n; ++j) {
                    long alt = dist[i][k] + dist[k][j];
                    if (alt < dist[i][j]) {
                        dist[i][j] = alt;
                        cnt[i][j] = (int) ((long) cnt[i][k] * cnt[k][j] % MOD);
                    } else if (alt == dist[i][j]) {
                        cnt[i][j] = (cnt[i][j] + (int) ((long) cnt[i][k] * cnt[k][j] % MOD)) % MOD;
                    }
                }

        return cnt[0][n-1];
    }
}