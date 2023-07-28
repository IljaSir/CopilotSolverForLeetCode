class Solution {
    public int minSideJumps(int[] obstacles) {
        
        int n = obstacles.length;
        int[] dp = {1, 0, 1};
        for (int i = 1; i < n; ++i) {
            int[] ndp = new int[3];
            for (int j = 0; j < 3; ++j)
                ndp[j] = 1 + Math.min(dp[0] + (j == 0 ? 1 : 0), Math.min(dp[1] + (j == 1 ? 1 : 0), dp[2] + (j == 2 ? 1 : 0)));
            if (obstacles[i] > 0)
                ndp[obstacles[i] - 1] = Integer.MAX_VALUE;
            if (i + 1 < n && obstacles[i + 1] > 0)
                ndp[obstacles[i + 1] - 1] = Integer.MAX_VALUE;
            dp = ndp;
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}