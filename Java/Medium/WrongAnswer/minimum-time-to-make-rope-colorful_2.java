class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[][] dp = new int[n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                dp[i][j] = i == 0 ? 0 : dp[i - 1][j];
            }
            dp[i][colors.charAt(i) - 'a'] += neededTime[i];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            res = Math.min(res, dp[n - 1][i]);
        }
        return res;
    }
}