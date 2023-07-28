class Solution {
    public int maximumANDSum(int[] nums, int numSlots) {
        
        int n = nums.length;
        int[][] dp = new int[numSlots + 1][1 << n];
        for (int i = 0; i < n; i++) {
            dp[1][1 << i] = nums[i];
        }
        for (int i = 2; i <= numSlots; i++) {
            for (int j = 1; j < (1 << n); j++) {
                int t = j;
                while (t > 0) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - t] + dp[1][t]);
                    t = (t - 1) & j;
                }
            }
        }
        return dp[numSlots][(1 << n) - 1];
    }
}