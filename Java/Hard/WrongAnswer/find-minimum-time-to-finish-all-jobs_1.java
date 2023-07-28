class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int n = jobs.length;
        int[][] dp = new int[k + 1][1 << n];
        for (int i = 0; i <= k; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++) {
            for (int mask = 1; mask < (1 << n); mask++) {
                int x = mask;
                int s = 0;
                while (x > 0) {
                    int j = Integer.numberOfTrailingZeros(x);
                    s += jobs[j];
                    x ^= (1 << j);
                    dp[i][mask] = Math.min(dp[i][mask], Math.max(dp[i - 1][mask ^ (1 << j)], s));
                }
            }
        }
        return dp[k][(1 << n) - 1];
    }
}