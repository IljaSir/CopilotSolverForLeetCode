class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int n = dist.length;
        if (n - 1 > hour) {
            return -1;
        }
        int l = 1;
        int r = 10000000;
        while (l < r) {
            int m = (l + r) / 2;
            if (check(dist, m, hour)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    private boolean check(int[] dist, int speed, double hour) {
        double sum = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            sum += Math.ceil(dist[i] * 1.0 / speed);
        }
        sum += dist[dist.length - 1] * 1.0 / speed;
        return sum <= hour;
    }
}