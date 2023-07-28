class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int[] min = new int[n];
        for (int i = 0; i < n; i++) {
            min[i] = arr[i];
            if (i >= k) {
                min[i] = Math.min(min[i], min[i - k]);
            }
            if (i > 0) {
                dp[i] = dp[i - 1] + Math.max(0, min[i] - arr[i] + 1);
                if (i >= k) {
                    dp[i] = Math.min(dp[i], dp[i - k] + Math.max(0, min[i] - arr[i] + 1));
                }
            }
        }
        return dp[n - 1];
    }
}