class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        
        int n = nums.length;
        double[] prefix = new double[n+1];
        for (int i=0; i<n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        double[] dp = new double[n];
        for (int i=0; i<n; i++) {
            dp[i] = (prefix[n] - prefix[i]) / (n - i);
        }
        for (int m=0; m<k-1; m++) {
            for (int i=0; i<n; i++) {
                for (int j=i+1; j<n; j++) {
                    dp[i] = Math.max(dp[i], (prefix[j] - prefix[i]) / (j - i) + dp[j]);
                }
            }
        }
        return dp[0];
    }
}