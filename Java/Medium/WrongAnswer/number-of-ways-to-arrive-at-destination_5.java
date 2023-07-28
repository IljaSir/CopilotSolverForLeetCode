class Solution {
    public int countPaths(int n, int[][] roads) {
        
        int[][] dp = new int[n][n];
        int[][] count = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[i][i] = 0;
            count[i][i] = 1;
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int w = road[2];
            dp[u][v] = w;
            dp[v][u] = w;
            count[u][v] = 1;
            count[v][u] = 1;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][k] < Integer.MAX_VALUE && dp[k][j] < Integer.MAX_VALUE) {
                        if (dp[i][k] + dp[k][j] < dp[i][j]) {
                            dp[i][j] = dp[i][k] + dp[k][j];
                            count[i][j] = count[i][k] * count[k][j] % 1000000007;
                        } else if (dp[i][k] + dp[k][j] == dp[i][j]) {
                            count[i][j] = (count[i][j] + count[i][k] * count[k][j] % 1000000007) % 1000000007;
                        }
                    }
                }
            }
        }
        return count[0][n - 1];
    }
}