class Solution {
    public int splitArray(int[] nums, int k) {
        
        int len = nums.length;
        int[] sums = new int[len+1];
        for (int i = 0; i < len; i++) {
            sums[i+1] = sums[i] + nums[i];
        }
        int[][] dp = new int[k+1][len+1];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int j = i; j <= len; j++) {
                for (int p = 0; p < j; p++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i-1][p], sums[j] - sums[p]));
                }
            }
        }
        return dp[k][len];
    }
}