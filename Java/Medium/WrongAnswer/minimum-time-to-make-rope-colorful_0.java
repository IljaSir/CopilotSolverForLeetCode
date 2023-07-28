class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                int c = colors.charAt(i) - 'a';
                if (c == j) {
                    dp[i][j] = neededTime[i];
                    if (i > 0) {
                        for (int k = 0; k < 3; k++) {
                            if (k != j) {
                                dp[i][j] = Math.min(dp[i][j], dp[i - 1][k]);
                            }
                        }
                    }
                } else {
                    if (i > 0) {
                        dp[i][j] = dp[i - 1][j] + neededTime[i];
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}