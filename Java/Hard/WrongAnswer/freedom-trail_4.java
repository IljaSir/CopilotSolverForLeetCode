class Solution {
    public int findRotateSteps(String ring, String key) {
        
        int m = ring.length();
        int n = key.length();
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int j = 0; j < m; j++) {
            if (ring.charAt(j) == key.charAt(0)) {
                dp[0][j] = Math.min(j, m - j) + 1;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ring.charAt(j) != key.charAt(i)) {
                    continue;
                }
                for (int k = 0; k < m; k++) {
                    if (dp[i - 1][k] == Integer.MAX_VALUE) {
                        continue;
                    }
                    int diff = Math.abs(j - k);
                    int step = Math.min(diff, m - diff);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + step);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            res = Math.min(res, dp[n - 1][j]);
        }
        return res;
    }
}