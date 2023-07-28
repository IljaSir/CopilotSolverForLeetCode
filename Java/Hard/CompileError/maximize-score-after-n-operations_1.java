class Solution {
    public int maxScore(int[] nums) {
        
        int n = nums.length;
        int[][] dp = new int[1 << n][n];
        for (int i = 0; i < 1 << n; i++) {
            Arrays.fill(dp[i], -1);
        }
        return dfs(0, 0, nums, dp);
    }

    private int dfs(int mask, int index, int[] nums, int[][] dp) {
        if (index >= nums.length) {
            return 0;
        }
        if (dp[mask][index] != -1) {
            return dp[mask][index];
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if ((mask & (1 << j)) == 0) {
                        int newMask = mask | (1 << i) | (1 << j);
                        max = Math.max(max, dfs(newMask, index + 1, nums, dp) + (index + 1) * gcd(nums[i], nums[j]));
                    }
                }
            }
        }
        dp[mask][index] = max;
        return max;
    }
}