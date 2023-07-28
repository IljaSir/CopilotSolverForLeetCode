class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(nums, 0, 0, dp);
    }
    
    private int dfs(int[] nums, int i, int mask, int[][] dp) {
        if (i == nums.length / 2) {
            return 0;
        }
        if (dp[i][mask] != -1) {
            return dp[i][mask];
        }
        int max = 0;
        for (int j = 0; j < nums.length; j++) {
            if ((mask & (1 << j)) == 0) {
                for (int k = j + 1; k < nums.length; k++) {
                    if ((mask & (1 << k)) == 0) {
                        max = Math.max(max, i + 1 + dfs(nums, i + 1, mask | (1 << k) | (1 << j), dp));
                    }
                }
            }
        }
        dp[i][mask] = max;
        return max;
    }
}