class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i];
            if (i - k >= 0) {
                dp[i] = Math.max(dp[i], dp[i - k] + 1);
            }
            if (i > 0) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
            }
            arr[i] = Math.max(arr[i], dp[i]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += arr[i] - dp[i];
        }
        return ans;
    }
}