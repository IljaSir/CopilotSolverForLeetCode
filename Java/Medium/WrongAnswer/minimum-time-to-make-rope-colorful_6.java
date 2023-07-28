class Solution {
    public int minCost(String colors, int[] neededTime) {
        
        int n = colors.length();
        int[][] dp = new int[n][3];
        for (int[] d: dp) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 0) {
                    dp[i][j] = (colors.charAt(i) - 'a' == j ? 0 : neededTime[i]);
                }
                else {
                    for (int k = 0; k < 3; k++) {
                        if (j != k) {
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + (colors.charAt(i) - 'a' == j ? 0 : neededTime[i]));
                        }
                    }
                }
            }
        }
        return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
    }
}