class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[71];
        Arrays.fill(dp, 1000);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int[] dp2 = new int[71];
            Arrays.fill(dp2, 1000);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k <= 70; k++) {
                    dp2[Math.min(70, k + mat[i][j])] = Math.min(dp2[Math.min(70, k + mat[i][j])], dp[k]);
                    dp2[Math.abs(k - mat[i][j])] = Math.min(dp2[Math.abs(k - mat[i][j])], dp[k] + 1);
                }
            }
            dp = dp2;
        }
        return dp[target];
    }
}