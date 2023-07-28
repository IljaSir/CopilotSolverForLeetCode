class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int n = dist.length;
        if (n - 1 > hour) return -1;
        int left = 1, right = (int) 1e7;
        while (left < right) {
            int mid = left + (right - left) / 2;
            double time = 0;
            for (int i = 0; i < n - 1; ++i) {
                time += Math.ceil((double) dist[i] / mid);
            }
            time += (double) dist[n - 1] / mid;
            if (time > hour) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}