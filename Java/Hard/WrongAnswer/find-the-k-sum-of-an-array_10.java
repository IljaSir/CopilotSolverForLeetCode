class Solution {
    public long kSum(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[1 << n];
        for (int i = 0; i < (1 << n); i++) {
            for (int j = 0; j < n; j++) {
                if (((i >> j) & 1) == 1) {
                    dp[i] += nums[j];
                }
            }
        }
        Arrays.sort(dp);
        return dp[dp.length - k];
    }
}