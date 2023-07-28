class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            int last = i & (-i);
            sum[i] = sum[i ^ last] + jobs[Integer.bitCount(last - 1)];
        }
        int[] dp = new int[1 << n];
        for (int i = 1; i < 1 << n; i++) {
            dp[i] = sum[i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = 1; j < 1 << n; j++) {
                for (int k1 = j; k1 > 0; k1 = (k1 - 1) & j) {
                    dp[j] = Math.min(dp[j], Math.max(dp[k1], sum[j ^ k1]));
                }
            }
        }
        return dp[(1 << n) - 1];
    }
}