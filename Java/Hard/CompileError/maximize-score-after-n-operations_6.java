class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dfs(nums, 1 << i, i, dp));
        }
        return res;
    }
    private int dfs(int[] nums, int mask, int last, int[][] dp) {
        if (dp[mask][last] != -1) {
            return dp[mask][last];
        }
        int n = nums.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if ((mask & (1 << i)) == 0) {
                res = Math.max(res, dfs(nums, mask | (1 << i), i, dp) + (Integer.bitCount(mask) + 1) * gcd(nums[last], nums[i]));
            }
        }
        dp[mask][last] = res;
        return res;
    }
}