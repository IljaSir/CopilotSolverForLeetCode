class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = -1;
            }
        }
        int[] prefix = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }
        return dfs(nums, 0, k, prefix, dp);
    }
    private int dfs(int[] nums, int idx, int k, int[] prefix, int[][] dp) {
        if (k == 0) {
            return 0;
        }
        if (idx >= nums.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[idx][k] != -1) {
            return dp[idx][k];
        }
        int min = Integer.MAX_VALUE;
        for (int i = idx; i < nums.length; i++) {
            int left = prefix[i + 1] - prefix[idx];
            int right = dfs(nums, i + 2, k - 1, prefix, dp);
            if (right == Integer.MAX_VALUE) {
                break;
            }
            min = Math.min(min, Math.max(left, right));
        }
        return dp[idx][k] = min;
    }
}