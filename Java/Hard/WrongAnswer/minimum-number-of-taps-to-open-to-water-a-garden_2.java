class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = Math.max(0, i - ranges[i]); j <= Math.min(n, i + ranges[i]); j++) {
                dp[j] = Math.min(dp[j], dp[Math.max(0, i - ranges[i])] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}