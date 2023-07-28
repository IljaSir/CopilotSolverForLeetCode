class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        // dp[i][j] := min operations to reach j using first i numbers
        int[][] dp = new int[n + 1][1001];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][start] = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j <= 1000; ++j) {
                if (dp[i][j] == Integer.MAX_VALUE) {
                    continue;
                }
                if (j + nums[i] <= 1000) {
                    dp[i + 1][j + nums[i]] = Math.min(dp[i + 1][j + nums[i]], dp[i][j] + 1);
                }
                if (j - nums[i] >= 0) {
                    dp[i + 1][j - nums[i]] = Math.min(dp[i + 1][j - nums[i]], dp[i][j] + 1);
                }
                dp[i + 1][j ^ nums[i]] = Math.min(dp[i + 1][j ^ nums[i]], dp[i][j] + 1);
            }
        }
        return dp[n][goal] == Integer.MAX_VALUE ? -1 : dp[n][goal];
    }
}