class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> a[0] - b[0]);
        int res = 0;
        double cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            double time = (target - cars[i][0]) * 1.0 / cars[i][1];
            if (time > cur) {
                res++;
                cur = time;
            }
        }
        return res;
    }
}