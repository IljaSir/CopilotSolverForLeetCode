class Solution {
    public long repairCars(int[] ranks, int cars) {
        
        int n = ranks.length;
        Arrays.sort(ranks);
        long s dp = new long[n];
        for (int i = 0; i < n; ++i) {
            dp[i] = (long)ranks[i] * (i + 1) * (i + 1);
        }
        for (int i = 1; i < n; ++i) {
            dp[i] = Math.min(dp[i], dp[i - 1]);
        }
        long l = 0, r = (long)1e18;
        while (l < r) {
            long mid = l + r >> 1;
            long count = 0;
            for (int i = 0; i < n; ++i) {
                count += (long)Math.sqrt(mid / ranks[i]);
            }
            if (count >= cars) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}