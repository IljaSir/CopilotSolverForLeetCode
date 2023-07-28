class Solution {
    public int kIncreasing(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = Math.max(0, i - k); j < i; j++) {
                min = Math.min(min, dp[j]);
            }
            dp[i] = Math.max(0, arr[i] - arr[i - 1] + 1) + min;
        }
        return dp[n - 1];
    }
}