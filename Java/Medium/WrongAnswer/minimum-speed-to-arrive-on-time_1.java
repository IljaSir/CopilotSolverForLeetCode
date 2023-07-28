class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int n = dist.length;
        int lo = 1;
        int hi = 10000000;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canFinish(mid, dist, hour)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo == 10000000 ? -1 : lo;
    }
    
    private boolean canFinish(int speed, int[] dist, double hour) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil(dist[i] * 1.0 / speed);
        }
        time += dist[dist.length - 1] * 1.0 / speed;
        return time <= hour;
    }
}