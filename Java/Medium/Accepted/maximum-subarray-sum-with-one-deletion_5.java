class Solution {
    public int maximumSum(int[] arr) {
        
        int n = arr.length;
        int[] dp = new int[n];
        int[] dp2 = new int[n];
        dp[0] = arr[0];
        dp2[0] = arr[0];
        int ans = arr[0];
        for(int i = 1; i < n; i++){
            dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
            dp2[i] = Math.max(dp2[i-1] + arr[i], dp[i-1]);
            ans = Math.max(ans, Math.max(dp[i], dp2[i]));
        }
        return ans;
    }
}