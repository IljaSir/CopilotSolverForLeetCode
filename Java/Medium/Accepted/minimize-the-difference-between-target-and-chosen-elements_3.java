class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[80 * 70 + 1];
        for (int i = 0; i < 80 * 70 + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int[] ndp = new int[80 * 70 + 1];
            for (int j = 0; j < 80 * 70 + 1; j++) {
                ndp[j] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 80 * 70 + 1; k++) {
                    if (dp[k] != Integer.MAX_VALUE) {
                        ndp[k + mat[i][j]] = Math.min(ndp[k + mat[i][j]], dp[k] + mat[i][j]);
                    }
                }
            }
            dp = ndp;
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 80 * 70 + 1; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                ans = Math.min(ans, Math.abs(dp[i] - target));
            }
        }
        return ans;
    }
}