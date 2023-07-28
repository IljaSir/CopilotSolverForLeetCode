class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        if (n == 1) return 1;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        double time = (target - cars[0][0]) / (double)cars[0][1];
        int fleets = 1;
        for (int i = 1; i < n; i++) {
            double t = (target - cars[i][0]) / (double)cars[i][1];
            if (t > time) {
                fleets++;
                time = t;
            }
        }
        return fleets;
    }
}