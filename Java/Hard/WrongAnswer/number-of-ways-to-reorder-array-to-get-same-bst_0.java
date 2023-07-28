class Solution {
    public int numOfWays(int[] nums) {
        
        int n = nums.length;
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j]) * j % 1000000007;
            }
        }
        return (int) (dfs(nums, 0, n - 1, dp) - 1);
    }

    private long dfs(int[] nums, int l, int r, long[][] dp) {
        if (l >= r) {
            return 1;
        }
        int m = l + 1;
        while (m <= r && nums[m] < nums[l]) {
            m++;
        }
        return dp[r - l][m - l - 1] * dfs(nums, l + 1, m - 1, dp) % 1000000007 * dfs(nums, m, r, dp) % 1000000007;
    }
}