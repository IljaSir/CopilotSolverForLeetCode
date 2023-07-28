class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int max = arr[i];
            for (int j = 1; j <= k && i - j + 1 >= 0; j++) {
                max = Math.max(max, arr[i - j + 1]);
                dp[i] = Math.max(dp[i], (i >= j ? dp[i - j] : 0) + max * j);
            }
        }
        return dp[arr.length - 1];
    }
}