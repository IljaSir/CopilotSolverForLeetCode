class Solution {
    public long minimumDifference(int[] nums) {
        
        int n = nums.length / 3;
        Arrays.sort(nums);
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < nums.length; ++i) {
            int x = nums[i];
            for (int j = Math.min(i + 1, n); j >= 0; --j) {
                for (int k = Math.min(i + 1, n) - j; k >= 0; --k) {
                    if (dp[j][k] == Long.MAX_VALUE) {
                        continue;
                    }
                    if (j < n) {
                        dp[j + 1][k] = Math.min(dp[j + 1][k], dp[j][k] + x);
                    }
                    if (k < n) {
                        dp[j][k + 1] = Math.min(dp[j][k + 1], dp[j][k] - x);
                    }
                }
            }
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i <= n; ++i) {
            ans = Math.min(ans, dp[i][n - i]);
        }
        return ans;
    }
}