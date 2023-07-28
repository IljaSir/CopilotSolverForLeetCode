class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = sum; j >= nums[i]; j--) {
                for (int k = 1; k <= n / 2; k++) {
                    if (dp[k - 1][j - nums[i]] >= 0) {
                        dp[k][j] = Math.max(dp[k][j], dp[k - 1][j - nums[i]] + nums[i]);
                    }
                }
            }
        }
        for (int i = 1; i <= n / 2; i++) {
            if (sum * i % n == 0 && dp[i][sum * i / n] > 0) {
                return true;
            }
        }
        return false;
    }
}