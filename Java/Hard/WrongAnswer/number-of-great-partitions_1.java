class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int[] preSum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int mod = (int) 1e9 + 7;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (preSum[j + 1] - preSum[i + 1] >= k) {
                    dp[j + 1] = (dp[j + 1] + dp[i + 1]) % mod;
                }
            }
            ans = (ans + dp[i + 1]) % mod;
        }
        return ans;
    }
}