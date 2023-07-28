class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int min = 1;
        int max = 10000000;
        while (min < max) {
            int mid = (min + max) / 2;
            double time = 0;
            for (int i = 0; i < dist.length; i++) {
                if (i == dist.length - 1) {
                    time += (double) dist[i] / mid;
                } else {
                    time += Math.ceil((double) dist[i] / mid);
                }
            }
            if (time <= hour) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min == 10000000 ? -1 : min;
    }
}