class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = arr[0];
        dp2[n - 1] = arr[n - 1];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], arr[i] + dp[i - 1]);
            max = Math.max(max, dp[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            dp2[i] = Math.max(arr[i], arr[i] + dp2[i + 1]);
        }
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, dp[i - 1] + dp2[i + 1]);
        }
        return max;
    }
}