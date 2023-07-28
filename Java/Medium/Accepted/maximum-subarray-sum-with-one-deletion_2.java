class Solution {
    public int maximumSum(int[] arr) {
        
        int max = arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            max = Math.max(max, dp[i]);
        }
        int[] dp2 = new int[arr.length];
        dp2[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1] + arr[i], arr[i]);
        }
        for (int i = 1; i < arr.length - 1; i++) {
            max = Math.max(max, dp[i - 1] + dp2[i + 1]);
        }
        return max;
    }
}