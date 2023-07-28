class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        
        int n = nums.length;
        int[][] dp = new int[n][k+2];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= k+1; j++) {
                dp[i][j] = Integer.MAX_VALUE / 2;
            }
        }
        dp[0][1] = 0;
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, nums[i]);
            sum += nums[i];
            dp[i][1] = max * (i+1) - sum;
        }
        for (int i = 1; i < n; i++) {
            max = nums[i];
            sum = nums[i];
            for (int j = i-1; j >= 0; j--) {
                max = Math.max(max, nums[j]);
                sum += nums[j];
                for (int l = 1; l <= k+1; l++) {
                    dp[i][l] = Math.min(dp[i][l], dp[j][l-1] + max * (i-j) - sum);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= k+1; i++) {
            ans = Math.min(ans, dp[n-1][i]);
        }
        return ans;
    }
}