class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        long[] gaps = new long[n-1];
        for (int i = 0; i < n-1; i++) {
            gaps[i] = stations[i+1] - stations[i] - 1;
        }
        long lo = 0;
        long hi = (long) 1e9;
        while (lo < hi) {
            long mid = (lo + hi + 1) / 2;
            if (check(gaps, r, k, mid)) {
                lo = mid;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public boolean check(long[] gaps, int r, int k, long mid) {
        int n = gaps.length;
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            long gap = gaps[i];
            if (gap <= 2 * r) {
                long add = gap / (r + 1);
                if (gap % (r + 1) != 0) {
                    add++;
                }
                cnt += add;
            } else {
                cnt += (gap - 2 * r + r) / (r + 1);
            }
        }
        return cnt <= k;
    }
}