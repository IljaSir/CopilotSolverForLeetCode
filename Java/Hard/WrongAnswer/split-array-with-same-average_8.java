class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int len = nums.length;
        int half = len / 2;
        int[][] dp = new int[half + 1][sum + 1];
        for (int i = 0; i < len; i++) {
            for (int j = half; j > 0; j--) {
                for (int k = sum; k > 0; k--) {
                    if (k >= nums[i]) {
                        dp[j][k] = Math.max(dp[j][k], dp[j - 1][k - nums[i]] + nums[i]);
                    }
                }
            }
        }
        for (int i = 1; i <= half; i++) {
            if (sum * i % len == 0 && dp[i][sum * i / len] * len == sum * i) {
                return true;
            }
        }
        return false;
    }
}