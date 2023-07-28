class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length / 2;
        int[][] dp = new int[1 << n][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(nums, 0, 0, 0, dp);
    }
    private int dfs(int[] nums, int mask, int i, int j, int[][] dp) {
        if (j == nums.length / 2) {
            return 0;
        }
        if (dp[mask][j] != -1) {
            return dp[mask][j];
        }
        int ans = 0;
        for (int k = i; k < nums.length; k++) {
            if ((mask & (1 << k)) == 0) {
                for (int l = k + 1; l < nums.length; l++) {
                    if ((mask & (1 << l)) == 0) {
                        ans = Math.max(ans, dfs(nums, mask | (1 << k) | (1 << l), k + 1, j + 1, dp) + (j + 1) * gcd(nums[k], nums[l]));
                    }
                }
            }
        }
        return dp[mask][j] = ans;
    }
}