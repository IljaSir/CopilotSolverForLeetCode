class Solution {
    public int findRotateSteps(String ring, String key) {
        
        int m = ring.length(), n = key.length();
        int[][] dp = new int[n + 1][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = 0; k < m; k++) {
                    if (ring.charAt(k) == key.charAt(i)) {
                        int diff = Math.abs(j - k);
                        int step = Math.min(diff, m - diff);
                        dp[i][j] = Math.min(dp[i][j], step + dp[i + 1][k]);
                    }
                }
            }
        }
        return dp[0][0] + n;
    }
}