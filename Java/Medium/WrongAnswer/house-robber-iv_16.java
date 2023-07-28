class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums, 0, k, dp);
    }
    int dfs(int[] nums, int i, int k, int[][] dp) {
        if (i >= nums.length) {
            return 0;
        }
        if (k == 0) {
            return 0;
        }
        if (dp[i][k] != -1) {
            return dp[i][k];
        }
        int res = Integer.MAX_VALUE;
        for (int j = i; j < nums.length; j++) {
            int max = 0;
            for (int l = i; l <= j; l++) {
                max = Math.max(max, nums[l]);
            }
            res = Math.min(res, max + dfs(nums, j + 2, k - 1, dp));
        }
        return dp[i][k] = res;
    }
}