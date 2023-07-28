class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        int n = ranks.length;
        long[] dp = new long[n];
        dp[0] = ranks[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + ranks[i];
        }
        long l = 0, r = 1_000_000_000_000_000_000L;
        while (l < r) {
            long m = (l + r) / 2;
            long c = 0;
            for (int i = 0; i < n; i++) {
                c += m / (ranks[i] * ranks[i]);
            }
            if (c >= cars) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}