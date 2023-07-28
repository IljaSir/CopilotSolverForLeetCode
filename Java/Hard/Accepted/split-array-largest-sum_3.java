class Solution {
    public int splitArray(int[] nums, int k) {
        
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for (int i = 0; i < n; i++) {
            dp[i][1] = prefix[i + 1];
        }
        for (int i = 0; i < n; i++) {
            for (int j = 2; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[l][j - 1], prefix[i + 1] - prefix[l + 1]));
                }
            }
        }
        return dp[n - 1][k];
    }
}