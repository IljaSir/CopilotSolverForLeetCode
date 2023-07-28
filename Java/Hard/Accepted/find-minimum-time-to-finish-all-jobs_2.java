class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int n = jobs.length;
        int[] sum = new int[1 << n];
        for (int i = 1; i < (1 << n); i++) {
            int x = Integer.lowestOneBit(i);
            sum[i] = sum[i - x] + jobs[Integer.numberOfTrailingZeros(x)];
        }
        int[][] dp = new int[k][1 << n];
        for (int i = 0; i < (1 << n); i++) {
            dp[0][i] = sum[i];
        }
        for (int i = 1; i < k; i++) {
            for (int j = 0; j < (1 << n); j++) {
                int min = Integer.MAX_VALUE;
                for (int x = j; x > 0; x = (x - 1) & j) {
                    min = Math.min(min, Math.max(dp[i - 1][j - x], sum[x]));
                }
                dp[i][j] = min;
            }
        }
        return dp[k - 1][(1 << n) - 1];
    }
}