class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int mod = 1000000007;
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (sum[j] - sum[i] >= k) dp[j] = (dp[j] + dp[i]) % mod;
            }
        }
        return dp[n];
    }
}