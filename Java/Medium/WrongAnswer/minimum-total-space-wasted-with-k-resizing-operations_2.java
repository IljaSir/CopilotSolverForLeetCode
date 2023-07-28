class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            int max = nums[i];
            int sum = 0;
            for (int j = i; j < n; j++) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                if (i == 0) {
                    dp[j][0] = max * (j - i + 1) - sum;
                } else {
                    dp[j][0] = Math.min(dp[j][0], max * (j - i + 1) - sum);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                for (int l = 0; l < i; l++) {
                    dp[i][j] = Math.min(dp[i][j], dp[l][j - 1] + dp[i][0]);
                }
            }
        }
        return dp[n - 1][k];
    }
}