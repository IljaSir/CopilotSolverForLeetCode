class Solution {
    public int smallestValue(int n) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        dp[2] = 2;
        for (int i = 2; i <= n; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                dp[i] = i;
            }
            for (int j = i + i; j <= n; j += i) {
                dp[j] = Math.min(dp[j], dp[i] + dp[j / i]);
            }
        }
        return dp[n];
    }
}