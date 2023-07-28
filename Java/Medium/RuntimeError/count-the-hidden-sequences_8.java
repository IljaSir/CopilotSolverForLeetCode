class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        
        int n = differences.length;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long mod = (long)1e9 + 7;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + differences[i - 1];
        }
        for (int i = 1; i <= n; i++) {
            int l = lower - differences[i - 1];
            int r = upper - differences[i - 1];
            int lidx = Arrays.binarySearch(prefix, l);
            if (lidx < 0) {
                lidx = -lidx - 1;
            }
            int ridx = Arrays.binarySearch(prefix, r);
            if (ridx < 0) {
                ridx = -ridx - 2;
            }
            if (lidx <= ridx) {
                dp[i] = (prefix[ridx] - prefix[lidx - 1]) % mod;
            }
        }
        return (int)dp[n];
    }
}