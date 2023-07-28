class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        
        int n = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        boolean[][][] dp = new boolean[n][n + 1][sum + 1];
        dp[0][1][nums[0]] = true;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= i + 1; j++) {
                for (int k = 0; k <= sum; k++) {
                    dp[i][j][k] = dp[i - 1][j][k];
                    if (k >= nums[i]) {
                        dp[i][j][k] |= dp[i - 1][j - 1][k - nums[i]];
                    }
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (sum * i % n == 0 && dp[n - 1][i][sum * i / n]) {
                return true;
            }
        }
        return false;
    }
}