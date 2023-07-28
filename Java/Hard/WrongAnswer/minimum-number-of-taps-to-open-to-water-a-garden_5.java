class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            int l = Math.max(i - ranges[i], 0);
            int r = Math.min(i + ranges[i], n);
            for (int j = l; j < r; j++) {
                dp[j + 1] = Math.min(dp[j + 1], dp[l] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }
}