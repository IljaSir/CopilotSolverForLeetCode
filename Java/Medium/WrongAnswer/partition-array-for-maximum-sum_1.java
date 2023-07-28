class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int max = arr[i];
            int sum = max;
            for (int j = 1; j < k; j++) {
                if (i - j >= 0) {
                    max = Math.max(max, arr[i - j]);
                    sum = Math.max(sum, max * (j + 1) + (i - j > 0 ? dp[i - j - 1] : 0));
                } else {
                    break;
                }
            }
            dp[i] = sum;
        }
        return dp[n - 1];
    }
}