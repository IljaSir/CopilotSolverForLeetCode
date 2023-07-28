class Solution {
    public int minScore(int n, int[][] roads) {
        
        int[][] dist = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = 100000000;
            }
        }
        for (int[] road : roads) {
            dist[road[0]][road[1]] = road[2];
            dist[road[1]][road[0]] = road[2];
        }
        for (int i = 1; i <= n; i++) {
            dist[i][i] = 0;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, 100000000);
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] < 100000000) {
                    dp[j] = Math.min(dp[j], Math.max(dp[i], dist[i][j]));
                }
            }
        }
        return dp[n];
    }
}