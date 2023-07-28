class Solution {
    public long kSum(int[] nums, int k) {
        
        long[][] dp = new long[k + 1][nums.length + 1];
        for (int i = 1; i <= k; i++) {
            for (int j = 1; j <= nums.length; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], nums[j - 1] + dp[i - 1][j - 1]);
            }
        }
        return dp[k][nums.length];
    }
}