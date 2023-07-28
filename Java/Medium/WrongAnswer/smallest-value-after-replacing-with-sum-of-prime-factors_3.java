class Solution {
    public int smallestValue(int n) {
        
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                dp[j] = Math.min(dp[j], dp[i] + (j / i));
            }
        }
        return dp[n];
    }
}