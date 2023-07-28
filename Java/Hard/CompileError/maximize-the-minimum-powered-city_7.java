class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        long l = 1, r = (long) 1e18;
        while (l < r) {
            long mid = (l + r + 1) >> 1;
            if (check(stations, r, k, mid)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

    private boolean check(int[] stations, int r, int k, long mid) {
        int cnt = 0;
        for (int i = 0; i < stations.length; i++) {
            int l = stations[i], r = stations[i];
            while (i + 1 < stations.length && stations[i + 1] <= r + r) {
                l = stations[i + 1];
                i++;
            }
            cnt += (l - r + r) / (r + r + 1);
        }
        return cnt <= k;
    }
}