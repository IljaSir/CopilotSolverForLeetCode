class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[] dp = new int[1 << numSlots];
        for (int i = 0; i < n; i++) {
            int[] next = dp.clone();
            for (int mask = 0; mask < (1 << numSlots); mask++) {
                next[mask & nums[i]] = Math.max(dp[mask & nums[i]], dp[mask] + (nums[i] & mask));
            }
            dp = next;
        }
        return dp[0];
    }
}