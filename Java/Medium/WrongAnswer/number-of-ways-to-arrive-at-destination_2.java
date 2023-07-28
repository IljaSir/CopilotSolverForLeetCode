class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(g[i], Integer.MAX_VALUE / 2);
            g[i][i] = 0;
        }
        for (int[] r : roads) {
            g[r[0]][r[1]] = r[2];
            g[r[1]][r[0]] = r[2];
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                }
            }
        }
        int[] dp = new int[n];
        int[] cnt = new int[n];
        Arrays.fill(cnt, 1);
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g[i][j] != Integer.MAX_VALUE / 2) {
                    if (dp[j] > dp[i] + g[i][j]) {
                        dp[j] = dp[i] + g[i][j];
                        cnt[j] = cnt[i];
                    } else if (dp[j] == dp[i] + g[i][j]) {
                        cnt[j] = (cnt[j] + cnt[i]) % 1000000007;
                    }
                }
            }
        }
        return cnt[n - 1];
    }
}