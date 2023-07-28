class Solution {
    public int longestSquareStreak(int[] nums) {
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] * nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
                max = Math.max(max, dp[i]);
            } else {
                dp[i] = 1;
            }
        }
        return max >= 2 ? max : -1;
    }
}