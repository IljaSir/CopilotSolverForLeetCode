class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            if (i > 0 && arr[i] >= arr[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            }
        }
        int ans = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && arr[i] > arr[i + 1]) {
                break;
            }
            ans = Math.min(ans, n - 1 - i);
            if (i > 0) {
                ans = Math.min(ans, i - 1 + 1 + dp[i - 1]);
            }
        }
        return ans;
    }
}