class Solution {
    public int splitArray(int[] nums, int k) {
        
        int len = nums.length;
        int[][] dp = new int[len + 1][k + 1];
        int[] sum = new int[len + 1];
        for (int i = 0; i < len; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        for (int i = 0; i <= len; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= len; i++) {
            for (int j = 1; j <= k; j++) {
                for (int x = 0; x < i; x++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[x][j - 1], sum[i] - sum[x]));
                }
            }
        }
        return dp[len][k];
    }
}