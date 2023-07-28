class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int n = differences.length;
        int mod = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + differences[i];
        }
        for (int i = 0; i < n; i++) {
            long l = prefixSum[i] + lower;
            long r = prefixSum[i] + upper;
            int left = Arrays.binarySearch(prefixSum, l);
            if (left < 0) {
                left = -left - 1;
            }
            int right = Arrays.binarySearch(prefixSum, r);
            if (right < 0) {
                right = -right - 2;
            }
            if (left <= right) {
                dp[i + 1] = (dp[i + 1] + prefixSum[right + 1] - prefixSum[left] - l * (right - left + 1) + mod * 2) % mod;
            }
            dp[i + 1] = (dp[i + 1] + dp[i]) % mod;
        }
        return (int) dp[n];
    }
}