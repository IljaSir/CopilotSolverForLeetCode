class Solution {
    public int minimizeSum(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + Math.min(dp[i - 1][0], dp[i - 1][1] - nums[i - 1]);
        }
        return Math.min(dp[n - 1][0], dp[n - 1][1]);
    }

    public int maxSum(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i] + Math.max(dp[i - 1][0], dp[i - 1][1] - nums[i - 1]);
        }
        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

    public int minDifference(int[] nums) {
        if (nums.length <= 4) {
            return 0;
        }
        int min = minimizeSum(nums);
        int max = maxSum(nums);
        return max - min;
    }
}