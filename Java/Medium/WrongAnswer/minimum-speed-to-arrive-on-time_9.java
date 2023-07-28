class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        long left = 1;
        long right = 10000000;
        while (left < right) {
            long mid = (left + right) / 2;
            if (canFinish(dist, hour, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left <= 10000000 ? (int) left : -1;
    }
    private boolean canFinish(int[] dist, double hour, long speed) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil((double) dist[i] / speed);
        }
        time += (double) dist[dist.length - 1] / speed;
        return time <= hour;
    }
}