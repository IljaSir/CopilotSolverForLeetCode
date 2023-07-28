class Solution {
    public double largestSumOfAverages(int[] nums, int k) {
        
        int n = nums.length;
        double[] dp = new double[n];
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            dp[i] = sum / (i + 1);
        }
        for (int i = 1; i < k; i++) {
            for (int j = n - 1; j > i - 1; j--) {
                sum = 0;
                for (int l = j; l > i - 1; l--) {
                    sum += nums[l];
                    dp[j] = Math.max(dp[j], dp[l - 1] + sum / (j - l + 1));
                }
            }
        }
        return dp[n - 1];
    }
}