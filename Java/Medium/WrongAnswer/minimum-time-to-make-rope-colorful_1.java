class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[][] dp = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int j = 0; j < 3; j++) {
            dp[0][j] = j == colors.charAt(0) - 'a' ? neededTime[0] : 0;
        }
        for (int i = 1; i < n; i++) {
            int c = colors.charAt(i) - 'a';
            for (int j = 0; j < 3; j++) {
                if (c == j) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + neededTime[i]);
                } else {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < 3; j++) {
            ans = Math.min(ans, dp[n - 1][j]);
        }
        return ans;
    }
}