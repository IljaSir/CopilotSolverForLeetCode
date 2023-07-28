class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[][] dp = new int[1 << numSlots][numSlots + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        return dfs(nums, 0, 0, numSlots, dp);
    }
    
    private int dfs(int[] nums, int mask, int i, int numSlots, int[][] dp) {
        if (i == nums.length) {
            return 0;
        }
        if (dp[mask][numSlots] != -1) {
            return dp[mask][numSlots];
        }
        int res = 0;
        if (numSlots > 0) {
            res = Math.max(res, dfs(nums, mask | (1 << i), i + 1, numSlots - 1, dp) + (nums[i] & (1 << i)));
        }
        res = Math.max(res, dfs(nums, mask, i + 1, numSlots, dp));
        return dp[mask][numSlots] = res;
    }
}