class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int[] dpRev = new int[n];
        dp[0] = arr[0];
        dpRev[n - 1] = arr[n - 1];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            dpRev[n - i - 1] = Math.max(dpRev[n - i] + arr[n - i - 1], arr[n - i - 1]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
            max = Math.max(max, dpRev[i]);
        }
        for (int i = 1; i < n - 1; i++) {
            max = Math.max(max, dp[i - 1] + dpRev[i + 1]);
        }
        return max;
    }
}