class Solution {
    public int minSideJumps(int[] obstacles) {
        
        int n = obstacles.length;
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    continue;
                }
                dp[i][j] = dp[i - 1][j];
                for (int k = 0; k < 3; k++) {
                    if (k == j) {
                        continue;
                    }
                    if (obstacles[i] == k + 1) {
                        continue;
                    }
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + 1);
                }
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}