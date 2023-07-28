class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        
        int n = nums.length;
        double[] prefix = new double[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        double[] dp = new double[n];
        for (int i = 0; i < n; i++) {
            dp[i] = (prefix[n] - prefix[i]) / (n - i);
        }
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < n; j++) {
                for (int m = j + 1; m < n; m++) {
                    dp[j] = Math.max(dp[j], (prefix[m] - prefix[j]) / (m - j) + dp[m]);
                }
            }
        }
        return dp[0];
    }
}