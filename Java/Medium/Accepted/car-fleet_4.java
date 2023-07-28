class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        if (n == 1) return 1;
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (target - position[i]) / (double) speed[i];
        }
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));
        int ans = 1;
        double curTime = cars[0][1];
        for (int i = 1; i < n; i++) {
            if (cars[i][1] > curTime) {
                ans++;
                curTime = cars[i][1];
            }
        }
        return ans;
    }
}