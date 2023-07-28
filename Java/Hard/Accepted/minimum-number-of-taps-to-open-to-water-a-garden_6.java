class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] dp = new int[n+1];
        Arrays.fill(dp, n+2);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(i + ranges[i], n);
            for (int j = left; j <= right; j++) {
                dp[j] = Math.min(dp[j], dp[left] + 1);
            }
        }
        return dp[n] == n+2 ? -1 : dp[n];
    }
}