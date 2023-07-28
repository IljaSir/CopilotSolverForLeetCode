class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 2);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            int l = Math.max(i - ranges[i], 0);
            int r = Math.min(i + ranges[i], n);
            for (int j = l; j <= r; j++) {
                dp[j] = Math.min(dp[j], dp[l] + 1);
            }
        }
        return dp[n] < n + 2 ? dp[n] : -1;
    }
}