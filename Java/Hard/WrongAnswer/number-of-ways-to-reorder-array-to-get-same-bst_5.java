class Solution {
    public int numOfWays(int[] nums) {
        
        int n = nums.length;
        long[][] dp = new long[2][n];
        dp[0][0] = 1;
        dp[1][0] = 1;
        for (int i = 1; i < n; i++) {
            int left = 0;
            int right = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    left++;
                } else {
                    right++;
                }
            }
            long[] dp2 = new long[2];
            for (int j = 0; j < 2; j++) {
                dp2[0] += dp[j][left];
                dp2[1] += dp[j][right];
            }
            for (int j = 0; j < 2; j++) {
                dp[j][i] = dp2[j] % 1000000007;
            }
        }
        return (int) ((dp[0][n - 1] + dp[1][n - 1] - 1) % 1000000007);
    }
}