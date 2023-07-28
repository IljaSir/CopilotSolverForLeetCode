class Solution {
    public int maximumCandies(int[] candies, long k) {
        
        int[] c = candies;
        int n = c.length;
        int lo = 0, hi = 1000000000;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += Math.min(mid, c[i]);
            }
            if (sum <= k) lo = mid;
            else hi = mid - 1;
        }
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.min(lo, c[i]);
        }
        return (int)(lo + (k - sum) / n);
    }
}