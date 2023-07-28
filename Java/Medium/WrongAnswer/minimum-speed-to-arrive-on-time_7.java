class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int n = dist.length;
        int lo = 1;
        int hi = (int)1e7;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            double time = 0;
            for (int i = 0; i < n - 1; i++) {
                time += Math.ceil(dist[i] * 1.0 / mid);
            }
            time += dist[n - 1] * 1.0 / mid;
            if (time > hour) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo > 1e7 ? -1 : lo;
    }
}