class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = 2;
                for (int k = 0; k < i; k++) {
                    if (nums[i] - nums[k] == nums[j] - nums[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}