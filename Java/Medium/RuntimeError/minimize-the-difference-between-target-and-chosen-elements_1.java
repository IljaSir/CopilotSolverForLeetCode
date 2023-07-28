class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
        
        int m = mat.length;
        int n = mat[0].length;
        int[] dp = new int[800];
        for (int i = 0; i < 800; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int[] temp = new int[800];
            for (int j = 0; j < 800; j++) {
                temp[j] = Integer.MAX_VALUE;
            }
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 800; k++) {
                    if (dp[k] != Integer.MAX_VALUE) {
                        temp[k + mat[i][j]] = Math.min(temp[k + mat[i][j]], dp[k]);
                    }
                }
            }
            dp = temp;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 800; i++) {
            if (dp[i] != Integer.MAX_VALUE) {
                res = Math.min(res, Math.abs(i - target));
            }
        }
        return res;
    }
}