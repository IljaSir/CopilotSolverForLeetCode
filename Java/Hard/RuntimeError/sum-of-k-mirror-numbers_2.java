class Solution {
    public long kMirror(int k, int n) {
        
        long[] dp = new long[n+1];
        dp[0] = 1;
        long res = 0;
        for (int i = 1; i <= n; i++) {
            long sum = 0;
            for (int j = 0; j < k; j++) {
                sum += dp[i - 1 - j];
            }
            dp[i] = sum;
            res += sum;
        }
        return res;
    }
}