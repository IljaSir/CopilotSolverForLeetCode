class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = arr[i] > arr[i - 1] ? dp[i - 1] : dp[i - 1] + 1;
        }
        int min = dp[n - 1];
        for (int i = n - 2; i >= k - 1; i--) {
            dp[i] = Math.min(dp[i], dp[i + 1] + 1);
            min = Math.min(min, dp[i] + i - k + 1);
        }
        return min;
    }
}