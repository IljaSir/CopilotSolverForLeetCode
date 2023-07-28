class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[][] dp = new int[n][k + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= k; j++) {
                int max = 0;
                for (int p = i; p >= 0; p--) {
                    max = Math.max(max, nums[p]);
                    if (p > 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[p - 1][j - 1] + (i - p + 1) * max - (sum[i + 1] - sum[p]));
                    } else {
                        dp[i][j] = Math.min(dp[i][j], (i - p + 1) * max - (sum[i + 1] - sum[p]));
                    }
                }
            }
        }
        return dp[n - 1][k];
    }
}