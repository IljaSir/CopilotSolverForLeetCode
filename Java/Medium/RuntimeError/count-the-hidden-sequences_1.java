class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int n = differences.length;
        long[] presum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            presum[i + 1] = presum[i] + differences[i];
        }
        long mod = (long) 1e9 + 7;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; ++i) {
            long min = presum[i] + lower;
            long max = presum[i] + upper;
            if (min > presum[i + 1] || max < presum[i + 1]) {
                return 0;
            }
            if (min <= presum[i + 1] && presum[i + 1] <= max) {
                dp[i + 1] = dp[i];
            }
            int minPos = Arrays.binarySearch(presum, min);
            if (minPos < 0) {
                minPos = -minPos - 1;
            }
            int maxPos = Arrays.binarySearch(presum, max);
            if (maxPos < 0) {
                maxPos = -maxPos - 1 - 1;
            }
            if (minPos <= maxPos) {
                dp[i + 1] = (dp[i + 1] + dp[minPos] - dp[maxPos + 1]) % mod;
            }
        }
        return (int) dp[n];
    }
}