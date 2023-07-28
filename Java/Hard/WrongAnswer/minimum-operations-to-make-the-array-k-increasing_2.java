class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + Math.max(0, arr[i] - arr[i - 1] + 1);
            if (i >= k) {
                dp[i] = Math.min(dp[i], dp[i - k] + Math.max(0, arr[i] - arr[i - k] + 1));
            }
        }
        return dp[n - 1];
    }
}