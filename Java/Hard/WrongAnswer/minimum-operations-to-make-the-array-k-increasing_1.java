class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 1; j <= k && i - j >= 0; j++) {
                if (arr[i] > arr[i - j]) {
                    dp[i] = Math.min(dp[i], dp[i - j] + (arr[i] - arr[i - j]));
                }
            }
        }
        return dp[n - 1];
    }
}