class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i]) - 1;
            if (dp[i] < 0) {
                return false;
            }
        }
        return true;
    }
}