class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        
        int n = nums.length;
        double[] preSum = new double[n+1];
        for (int i = 1; i <= n; i++) {
            preSum[i] = preSum[i-1] + nums[i-1];
        }
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (preSum[n] - preSum[i])/(n-i);
        }
        for (int i = 0; i < k-1; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = j+1; m < n; m++) {
                    dp[j] = Math.max(dp[j], (preSum[m] - preSum[j])/(m-j) + dp[m]);
                }
            }
        }
        return dp[0];
    }
}