class Solution {
    public int minimumTimeRequired(int[] jobs, int k) {
        
        int n = jobs.length;
        int[][] dp = new int[n + 1][1 << n];
        for (int i = 0; i < (1 << n); i++) {
            Arrays.fill(dp[0], Integer.MAX_VALUE / 2);
        }
        for (int i = 1; i <= n; i++) {
            for (int mask = 0; mask < (1 << n); mask++) {
                if (Integer.bitCount(mask) != i) {
                    continue;
                }
                int submask = mask;
                do {
                    dp[i][mask] = Math.min(dp[i][mask], Math.max(dp[i - Integer.bitCount(submask)][mask ^ submask], jobs[Integer.numberOfTrailingZeros(submask)]));
                    submask = (submask - 1) & mask;
                } while (submask != mask);
            }
        }
        return dp[n][(1 << n) - 1];
    }
}