class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[][] dp = new int[n][3];
        int[] last = new int[3];
        for (int i = 0; i < n; i++) {
            int c = colors.charAt(i) - 'a';
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i - 1][j];
            }
            dp[i][c] = Math.max(dp[i - 1][c], last[c]) + neededTime[i];
            last[c] = dp[i][c];
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}