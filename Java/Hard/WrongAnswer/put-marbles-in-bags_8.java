class Solution {
    public long putMarbles(int[] weights, int k) {
        
        long[] prefix = new long[weights.length+1];
        for (int i = 0; i < weights.length; i++) {
            prefix[i+1] = prefix[i] + weights[i];
        }
        long[] dp = new long[weights.length];
        for (int i = 0; i < weights.length; i++) {
            dp[i] = prefix[i+1];
        }
        for (int i = 1; i < k; i++) {
            long[] ndp = new long[weights.length];
            int l = 0;
            for (int j = 0; j < weights.length; j++) {
                while (l < j && Math.max(prefix[j+1]-prefix[l+1], dp[l]) >= Math.max(prefix[j+1]-prefix[l], dp[l+1])) {
                    l++;
                }
                ndp[j] = Math.max(prefix[j+1]-prefix[l], dp[l]);
            }
            dp = ndp;
        }
        long max = Long.MIN_VALUE;
        long min = Long.MAX_VALUE;
        for (int i = 0; i < weights.length; i++) {
            max = Math.max(max, dp[i]);
            min = Math.min(min, dp[i]);
        }
        return max - min;
    }
}