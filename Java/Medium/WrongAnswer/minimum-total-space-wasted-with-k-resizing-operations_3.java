class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k+1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        int[] sum = new int[n+1];
        for (int i = 0; i < n; i++) {
            sum[i+1] = sum[i] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = (sum[n] - sum[i]) - (n - i) * nums[i];
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = j; l < n; l++) {
                    int max = Math.max(nums[l], sum[l+1] - sum[j]);
                    dp[l][i] = Math.min(dp[l][i], dp[j][i-1] + (sum[l+1] - sum[j]) - max * (l - j + 1));
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i <= k; i++) {
            res = Math.min(res, dp[n-1][i]);
        }
        return res;
    }
}