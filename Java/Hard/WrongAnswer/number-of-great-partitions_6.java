class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j >= 0; j--) {
                sum += nums[j];
                if (sum >= k) {
                    dp[i + 1] += dp[j];
                    dp[i + 1] %= mod;
                }
            }
        }
        return dp[n];
    }
}