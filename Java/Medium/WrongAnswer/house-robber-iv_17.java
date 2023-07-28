class Solution {
    public int minCapability(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0;
            for (int j = 1; j <= k; j++) {
                int min = Integer.MAX_VALUE;
                for (int l = i - 1; l >= j - 1; l--) {
                    min = Math.min(min, Math.max(dp[l][j - 1], nums[i - 1]));
                }
                dp[i][j] = min;
            }
        }
        return dp[n][k];
    }
}