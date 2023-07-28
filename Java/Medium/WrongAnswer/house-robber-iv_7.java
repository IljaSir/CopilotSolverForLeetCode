class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums, k, 0, dp);
    }
    private int dfs(int[] nums, int k, int start, int[][] dp) {
        if (k == 0) {
            return 0;
        }
        if (start >= nums.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[start][k] != -1) {
            return dp[start][k];
        }
        int res = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {
            int max = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                max = Math.max(max, nums[j]);
                int next = dfs(nums, k - 1, j + 1, dp);
                if (next != Integer.MAX_VALUE) {
                    res = Math.min(res, max + next);
                }
            }
        }
        dp[start][k] = res;
        return res;
    }
}