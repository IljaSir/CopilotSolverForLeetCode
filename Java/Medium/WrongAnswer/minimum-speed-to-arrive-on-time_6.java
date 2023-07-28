class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        
        int n = dist.length;
        int maxSpeed = 10000000;
        int minSpeed = 1;
        while (minSpeed < maxSpeed) {
            int speed = minSpeed + (maxSpeed - minSpeed) / 2;
            double travelTime = 0;
            for (int i = 0; i < n - 1; i++) {
                travelTime += Math.ceil((double)dist[i] / speed);
            }
            travelTime += (double)dist[n - 1] / speed;
            if (travelTime <= hour) {
                maxSpeed = speed;
            } else {
                minSpeed = speed + 1;
            }
        }
        return minSpeed > 10000000 ? -1 : minSpeed;
    }
}