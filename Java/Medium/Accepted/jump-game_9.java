class Solution {
    public boolean canJump(int[] nums) {
        
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = i + nums[i];
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (i > max) {
                return false;
            }
            max = Math.max(max, dp[i]);
        }
        return true;
    }
}