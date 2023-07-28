class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            for (int j = i; j >= 0; j--) {
                if (sum - nums[j] >= k) {
                    dp[j + 1] = (dp[j + 1] + dp[j]) % mod;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dp[i]) % mod;
        }
        return (int) ans;
    }
}