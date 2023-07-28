class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = preSum[i] < k ? 0 : 1;
            for (int j = 0; j < i; j++) {
                if (preSum[i] - preSum[j] >= k) {
                    dp[i] += dp[j];
                    dp[i] %= 1000000007;
                }
            }
            ans += dp[i];
            ans %= 1000000007;
        }
        return ans;
    }
}