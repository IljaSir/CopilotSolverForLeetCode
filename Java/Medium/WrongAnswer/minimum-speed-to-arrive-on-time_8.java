class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int max = 10000000;
        int min = 1;
        while (min < max) {
            int mid = (max + min) / 2;
            double time = 0;
            for (int i = 0; i < dist.length - 1; i++) {
                time += Math.ceil(dist[i] * 1.0 / mid);
            }
            time += dist[dist.length - 1] * 1.0 / mid;
            if (time <= hour) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min == 10000000 ? -1 : min;
    }
}