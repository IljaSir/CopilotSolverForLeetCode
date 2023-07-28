class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(0, dp[i - 1] + arr[i - 1] - arr[i] + 1);
        }
        int ans = dp[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            int j = Math.max(0, i - k + 1);
            dp[i] = Math.max(dp[i], dp[j] + Math.max(0, arr[j] - arr[i] - 1));
            ans = Math.min(ans, dp[i] + n - i - 1);
        }
        return ans;
    }
}