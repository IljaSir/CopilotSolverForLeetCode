class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[71];
        for (int i = 0; i <= 70; i++) {
            dp[i] = Math.abs(target - i);
        }
        for (int i = 0; i < m; i++) {
            int[] dp2 = new int[71];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 70; k++) {
                    dp2[mat[i][j] + k] = Math.min(dp2[mat[i][j] + k], Math.abs(target - mat[i][j] - k));
                }
            }
            dp = dp2;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= 70; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }
}