class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        long l = 0;
        long r = 1000000000;
        long ans = 0;
        while (l <= r) {
            long mid = l + (r - l) / 2;
            if (check(stations, r, mid)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private boolean check(int[] stations, int r, long mid) {
        long cnt = 0;
        for (int i = 0; i < stations.length; i++) {
            int start = stations[i] - r;
            int end = stations[i] + r;
            long left = Math.max(0, start);
            long right = Math.min(mid, end);
            cnt += (right - left) / (r + 1);
        }
        return cnt >= k;
    }
}