class Solution {
    public int numOfWays(int[] nums) {
        
        int n = nums.length;
        int mod = 1000000007;
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                for (int k = i + 1; k <= j; k++) {
                    if (nums[k] > nums[i] && nums[k] < nums[j]) {
                        dp[i][j] = (dp[i][j] + dp[i + 1][k - 1] * dp[k][j]) % mod;
                    }
                }
                dp[i][j] = (dp[i][j] + dp[i + 1][j] + dp[i][j - 1]) % mod;
            }
        }
        return (int) (dp[0][n - 1] - 1);
    }
}