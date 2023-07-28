class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if (i == 0) {
                    if (colors.charAt(i) - 'a' == j) {
                        dp[i][j] = neededTime[i];
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (colors.charAt(i) - 'a' == j) {
                        dp[i][j] = dp[i - 1][j] + neededTime[i];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][colors.charAt(i) - 'a'], dp[i - 1][j]);
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            ans = Math.min(ans, dp[n - 1][i]);
        }
        return ans;
    }
}