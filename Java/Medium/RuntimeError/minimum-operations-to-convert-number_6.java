class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < 1001; i++) {
            dp[0][i] = Math.abs(i - start);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 1001; j++) {
                if (dp[i - 1][j] != -1) {
                    if (j + nums[i] <= 1000) {
                        dp[i][j + nums[i]] = Math.min(dp[i][j + nums[i]] != -1 ? dp[i][j + nums[i]] : Integer.MAX_VALUE, dp[i - 1][j] + 1);
                    }
                    if (j - nums[i] >= 0) {
                        dp[i][j - nums[i]] = Math.min(dp[i][j - nums[i]] != -1 ? dp[i][j - nums[i]] : Integer.MAX_VALUE, dp[i - 1][j] + 1);
                    }
                    dp[i][j ^ nums[i]] = Math.min(dp[i][j ^ nums[i]] != -1 ? dp[i][j ^ nums[i]] : Integer.MAX_VALUE, dp[i - 1][j] + 1);
                }
            }
        }
        return dp[n - 1][goal] == -1 ? -1 : dp[n - 1][goal];
    }
}