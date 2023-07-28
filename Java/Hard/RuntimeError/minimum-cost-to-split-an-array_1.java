class Solution {
    public int minCost(int[] nums, int k) {
        
        int n = nums.length;
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + (count[i] == 1 ? 1 : 0);
        }
        int[][] cost = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int max = 0;
                for (int l = i; l <= j; l++) {
                    max = Math.max(max, count[l]);
                }
                cost[i][j] = dp[j] - dp[i - 1] - max;
            }
        }
        int[][] dp2 = new int[n + 1][k + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp2[i][j] = Integer.MAX_VALUE;
                for (int l = 0; l < i; l++) {
                    dp2[i][j] = Math.min(dp2[i][j], dp2[l][j - 1] + cost[l + 1][i]);
                }
            }
        }
        return dp2[n][k];
    }
}