class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int[] dp1 = new int[n];
        dp[0] = arr[0];
        dp1[0] = arr[0];
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            dp1[i] = Math.max(dp[i - 1], dp1[i - 1] + arr[i]);
            max = Math.max(max, Math.max(dp[i], dp1[i]));
        }
        return max;
    }
}