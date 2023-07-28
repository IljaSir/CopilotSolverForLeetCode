class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        if (n == 0) return 0;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> b[0] - a[0]);
        int res = 1;
        double time = (double)(target - cars[0][0]) / cars[0][1];
        for (int i = 1; i < n; i++) {
            double t = (double)(target - cars[i][0]) / cars[i][1];
            if (t > time) {
                res++;
                time = t;
            }
        }
        return res;
    }
}