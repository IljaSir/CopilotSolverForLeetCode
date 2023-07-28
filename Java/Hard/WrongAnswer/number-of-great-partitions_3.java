class Solution {
    public int countPartitions(int[] nums, int k) {
        
        int n = nums.length;
        int[] dp = new int[n + 1];
        int[] sum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i; j > 0; j--) {
                if (sum[i] - sum[j - 1] >= k) {
                    dp[i] = (dp[i] + dp[j - 1] + 1) % 1000000007;
                }
            }
        }
        return dp[n];
    }
}