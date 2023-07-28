class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int n = dist.length;
        if (hour <= n - 1) return -1;
        int lo = 1, hi = (int) 1e7;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (canFinish(mid, dist, hour)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
    private boolean canFinish(int speed, int[] dist, double hour) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time += (double) dist[dist.length - 1] / speed;
        return time <= hour;
    }
}