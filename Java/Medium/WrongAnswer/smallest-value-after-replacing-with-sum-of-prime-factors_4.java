class Solution {
    public int smallestValue(int n) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= i; j++) {
                if (i % j != 0) {
                    continue;
                }
                int k = i / j;
                dp[i] = Math.min(dp[i], dp[j] + dp[k]);
            }
        }
        return dp[n];
    }
}