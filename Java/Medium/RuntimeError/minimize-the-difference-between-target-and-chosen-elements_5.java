class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int m = mat.length, n = mat[0].length;
        int[] dp = new int[71];
        Arrays.fill(dp, 10000);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int[] tmp = new int[71];
            Arrays.fill(tmp, 10000);
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 71; k++) {
                    tmp[Math.min(70, k + mat[i][j])] = Math.min(tmp[Math.min(70, k + mat[i][j])], dp[k]);
                    tmp[Math.max(0, k - mat[i][j])] = Math.min(tmp[Math.max(0, k - mat[i][j])], dp[k] + 1);
                }
            }
            dp = tmp;
        }
        return dp[target];
    }
}