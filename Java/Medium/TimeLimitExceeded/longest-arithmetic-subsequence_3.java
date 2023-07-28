class Solution {
    public int longestArithSeqLength(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int diff = nums[j] - nums[i];
                dp[i][j] = 2;
                for (int k = i - 1; k >= 0; k--) {
                    if (nums[k] + diff == nums[i]) {
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                    }
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res;
    }
}