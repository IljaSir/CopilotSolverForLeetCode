class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int dp[][] = new int[n][26];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return minCost(colors, neededTime, 0, -1, dp);
    }
    
    private int minCost(String colors, int[] neededTime, int i, int prev, int[][] dp) {
        if (i == colors.length()) {
            return 0;
        }
        if (dp[i][prev] != -1) {
            return dp[i][prev];
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < 26; j++) {
            if (j == prev) {
                min = Math.min(min, minCost(colors, neededTime, i + 1, prev, dp));
            } else {
                min = Math.min(min, minCost(colors, neededTime, i + 1, j, dp) + neededTime[i]);
            }
        }
        dp[i][prev] = min;
        return min;
    }
}