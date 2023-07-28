class Solution {
    public int maximumScore(int[] nums, int[] multipliers) {
        
        int n = nums.length;
        int m = multipliers.length;
        int[][] dp = new int[m + 1][m + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 0; j <= i; j++) {
                int k = i - j;
                if (j > 0) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - 1][k] + nums[j - 1] * multipliers[i - 1]);
                }
                if (k > 0) {
                    dp[j][k] = Math.max(dp[j][k], dp[j][k - 1] + nums[n - k] * multipliers[i - 1]);
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i <= m; i++) {
            ans = Math.max(ans, dp[i][m - i]);
        }
        return ans;
    }
}