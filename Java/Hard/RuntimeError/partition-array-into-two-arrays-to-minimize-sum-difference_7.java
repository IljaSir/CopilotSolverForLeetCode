class Solution {
    public int minimumDifference(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int[][] dp = new int[n + 1][sum / 2 + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - nums[i - 1]] + nums[i - 1]);
                }
            }
        }
        return sum - 2 * dp[n][sum / 2];
    }
}