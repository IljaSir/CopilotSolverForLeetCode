class Solution {
    public long kSum(int[] nums, int k) {
        
        int n = nums.length;
        long[] dp = new long[1 << n];
        for (int mask = 1; mask < (1 << n); mask++) {
            int i = Integer.numberOfTrailingZeros(mask);
            dp[mask] = nums[i] + dp[mask ^ (1 << i)];
        }
        Arrays.sort(dp);
        return dp[dp.length - k];
    }
}