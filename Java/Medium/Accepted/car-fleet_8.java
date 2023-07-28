class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        // int[] posSpeed = new int[position.length];
        // for (int i = 0; i < position.length; i++) {
        //     posSpeed[i] = position[i] * 1000000 + speed[i];
        // }
        // Arrays.sort(posSpeed);
        // int fleetCount = 0;
        // double lastFleetTime = 0.0;
        // for (int i = 0; i < posSpeed.length; i++) {
        //     double time = (target - posSpeed[i] / 1000000) / (posSpeed[i] % 1000000);
        //     if (time > lastFleetTime) {
        //         fleetCount++;
        //         lastFleetTime = time;
        //     }
        // }
        // return fleetCount;
        int n = position.length;
        int[][] cars = new int[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, new Comparator<int[]>() {
            @Override
            public int compare(int[] car1, int[] car2) {
                return car2[0] - car1[0];
            }
        });
        int ans = 0;
        double cur = 0;
        for (int[] car: cars) {
            double time = (double)(target - car[0]) / car[1];
            if (time > cur) {
                ans++;
                cur = time;
            }
        }
        return ans;
    }
}