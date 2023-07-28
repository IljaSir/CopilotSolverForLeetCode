class Solution {
    public int minimumDifference(int[] nums) {
        
        int sum = 0;
        for (int n : nums) {
            sum += n;
        }
        int n = nums.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1] && dp[i - 1][j - nums[i - 1]] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[n][i] != Integer.MAX_VALUE) {
                res = Math.min(res, Math.abs(sum - 2 * dp[n][i]));
            }
        }
        return res;
    }
}