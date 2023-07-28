class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        int[] sum = new int[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }

        for (int i = 0; i < n; i++) {
            dp[i][0] = (sum[n - 1] - sum[i]) + nums[i] * (i);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k; j++) {
                int max = nums[i];
                for (int p = i + 1; p < n; p++) {
                    max = Math.max(max, nums[p]);
                    if (dp[p][j - 1] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[p][j - 1] + (sum[p - 1] - sum[i]) - max * (p - i));
                    }
                }
            }
        }
        return dp[0][k];
    }
}