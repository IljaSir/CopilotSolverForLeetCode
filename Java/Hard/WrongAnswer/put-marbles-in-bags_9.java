class Solution {
    public long putMarbles(int[] weights, int k) {
        
        long total = 0;
        for (int i = 0; i < weights.length; i++)
            total += weights[i];
        long[] prefix = new long[weights.length + 1];
        for (int i = 1; i < prefix.length; i++)
            prefix[i] = prefix[i - 1] + weights[i - 1];
        long[] dp = new long[weights.length + 1];
        long[] ndp = new long[weights.length + 1];
        for (int i = 0; i < dp.length; i++)
            dp[i] = prefix[i];
        for (int i = 2; i <= k; i++) {
            Arrays.fill(ndp, 0);
            for (int j = i; j <= weights.length; j++) {
                ndp[j] = Long.MAX_VALUE;
                for (int l = i - 1; l < j; l++) {
                    long cost = prefix[j] - prefix[l];
                    ndp[j] = Math.min(ndp[j], dp[l] + cost);
                }
            }
            long[] temp = dp;
            dp = ndp;
            ndp = temp;
        }
        return dp[weights.length] - total;
    }
}