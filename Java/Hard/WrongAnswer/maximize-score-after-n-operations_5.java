class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[1 << n][n / 2 + 1];
        for (int i = 1; i < 1 << n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums, dp, 0, 0);
    }
    
    private int dfs(int[] nums, int[][] dp, int mask, int k) {
        if (k == nums.length / 2) {
            return 0;
        }
        if (dp[mask][k] != -1) {
            return dp[mask][k];
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if ((mask & (1 << j)) != 0) {
                    continue;
                }
                res = Math.max(res, k + 1 + dfs(nums, dp, mask | (1 << i) | (1 << j), k + 1));
            }
        }
        dp[mask][k] = res;
        return res;
    }
}