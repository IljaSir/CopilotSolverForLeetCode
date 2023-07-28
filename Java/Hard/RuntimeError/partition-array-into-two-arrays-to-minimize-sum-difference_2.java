class Solution {
    public int minimumDifference(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] dp = new int[n / 2 + 1][sum + 1];
        for (int i = 0; i <= n / 2; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = Math.min(i, n / 2); j >= 1; j--) {
                for (int k = nums[i - 1]; k <= sum; k++) {
                    if (dp[j - 1][k - nums[i - 1]] != Integer.MAX_VALUE) {
                        dp[j][k] = Math.min(dp[j][k], dp[j - 1][k - nums[i - 1]] + nums[i - 1]);
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum; i++) {
            if (dp[n / 2][i] != Integer.MAX_VALUE) {
                min = Math.min(min, Math.abs(sum - 2 * dp[n / 2][i]));
            }
        }
        return min;
    }
}