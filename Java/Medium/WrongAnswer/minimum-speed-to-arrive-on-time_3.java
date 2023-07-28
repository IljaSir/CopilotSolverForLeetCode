class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int n = dist.length;
        if (hour < n - 1) return -1;
        int left = 1, right = (int) 1e7;
        while (left < right) {
            int mid = left + (right - left) / 2;
            double d = 0;
            for (int i = 0; i < n - 1; i++) {
                d += Math.ceil(dist[i] * 1.0 / mid);
            }
            d += dist[n - 1] * 1.0 / mid;
            if (d <= hour) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}