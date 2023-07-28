class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int n = differences.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += differences[i];
            dp[i + 1] = dp[i] * Math.max(0, Math.min(upper - sum, upper - lower + 1));
            if (i > 0) {
                dp[i + 1] += dp[i - 1] * Math.max(0, Math.min(lower - 1 - sum, upper - lower + 1));
            }
            dp[i + 1] %= 1000000007;
        }
        return (int) dp[n];
    }
}