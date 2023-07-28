class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        int[][] dp = new int[k + 1][n];
        for (int i = 0; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = (sum[n] - sum[i]) - (n - i) * nums[i];
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[i - 1][j];
                int total = 0, max = 0;
                for (int p = j + 1; p < n; p++) {
                    total = sum[p] - sum[j];
                    max = Math.max(max, nums[p]);
                    int waste = total - max * (p - j + 1);
                    min = Math.min(min, waste + dp[i - 1][p]);
                }
                dp[i][j] = min;
            }
        }
        return dp[k][0];
    }
}