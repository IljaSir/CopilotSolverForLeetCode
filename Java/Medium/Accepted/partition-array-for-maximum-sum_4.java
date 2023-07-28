class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + j * max);
            }
        }
        return dp[n - 1];
    }
}