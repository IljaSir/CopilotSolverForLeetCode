class Solution {
    public int longestSquareStreak(int[] nums) {
        
        int n = nums.length;
        int maxLen = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && nums[i] / nums[j] == nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen > 1 ? maxLen : -1;
    }
}