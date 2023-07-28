class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 2];
        for (int i = 0; i <= n; ++i) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; ++i) {
            int max = 0;
            int sum = 0;
            for (int j = i; j < n; ++j) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                int space = max * (j - i + 1) - sum;
                for (int t = 0; t <= k + 1; ++t) {
                    dp[j + 1][t + 1] = Math.min(dp[j + 1][t + 1], dp[i][t] + space);
                }
            }
        }
        return dp[n][k + 1];
    }
}