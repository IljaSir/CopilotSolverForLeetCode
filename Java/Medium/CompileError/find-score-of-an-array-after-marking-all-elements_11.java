class Solution {
    public long findScore(int[] nums) {
        
        long score = 0;
        int n = nums.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = nums[i];
            if (i > 0) {
                dp[i] = Math.min(dp[i], dp[i - 1]);
            }
            if (i > 1) {
                dp[i;
    }
}