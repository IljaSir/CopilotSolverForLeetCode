class Solution {
    public long maxPower(int[] stations, int r, int k) {
        
        int n = stations.length;
        long left = 0, right = 0;
        for (int i = 0; i < n - 1; i++) {
            right = Math.max(right, (long) (stations[i + 1] - stations[i]) / (r * 2 + 1));
        }
        while (left < right) {
            long mid = (left + right + 1) / 2;
            if (check(stations, r, k, mid)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

    private boolean check(int[] stations, int r, int k, long mid) {
        long cnt = 0;
        int n = stations.length;
        for (int i = 0; i < n - 1; i++) {
            long l = stations[i] + mid * (r * 2 + 1);
            long r1 = stations[i + 1] - mid * (r * 2 + 1);
            if (l < r1) {
                cnt += (r1 - l) / (r * 2 + 1);
                if ((r1 - l) % (r * 2 + 1) != 0) {
                    cnt++;
                }
            }
        }
        return cnt <= k;
    }
}