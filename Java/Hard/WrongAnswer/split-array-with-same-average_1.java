class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int n = nums.length;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= nums[i - 1]) {
                    dp[i][j] |= dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (sum * i % n == 0 && dp[i][sum * i / n]) {
                return true;
            }
        }
        return false;
    }
}