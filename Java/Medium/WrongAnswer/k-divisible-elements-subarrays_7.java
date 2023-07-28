class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        
        int ans = 0;
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            dp[i + 1] = dp[i] + (nums[i] % p == 0 ? 1 : 0);
        }
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (dp[j] - dp[i] <= k) {
                    ans++;
                }
            }
        }
        return ans;
    }
}