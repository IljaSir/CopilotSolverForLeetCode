class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m+1][m+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1] + nums[j-1] * multipliers[i-1]);
                }
                if (j < i) {
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + nums[n-i+j] * multipliers[i-1]);
                }
            }
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            res = Math.max(res, dp[m][i]);
        }
        return res;
    }
}