class Solution {
    public int maxDistance(int[] colors) {
        
        int n = colors.length;
        int[][] dp = new int[n][101];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                dp[i][j] = i > 0 ? dp[i - 1][j] : 0;
                if (colors[i] == j) {
                    dp[i][j] = i;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= 100; j++) {
                if (colors[i] != j) {
                    res = Math.max(res, dp[i][j] - i);
                }
            }
        }
        return res;
    }
}