class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int n = differences.length;
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += differences[i];
            dp[i + 1] = (int) ((sum - upper >= 0 ? dp[upperIndex(dp, sum - upper)] : 0) - (sum - lower > 0 ? dp[upperIndex(dp, sum - lower - 1)] : 0));
            dp[i + 1] = (dp[i + 1] + mod) % mod;
        }
        return dp[n];
    }
    private int upperIndex(int[] dp, long target) {
        int left = 0;
        int right = dp.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (target >= dp[mid]) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}