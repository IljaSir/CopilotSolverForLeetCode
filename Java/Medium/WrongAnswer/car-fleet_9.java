class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int ans = 0;
        if (n == 0) return ans;
        if (n == 1) return 1;
        int[] pos = new int[n];
        int[] spd = new int[n];
        for (int i = 0; i < n; i++) {
            pos[i] = position[i];
            spd[i] = speed[i];
        }
        Arrays.sort(pos);
        double[] time = new double[n];
        for (int i = 0; i < n; i++) {
            time[i] = (double) (target - pos[i]) / spd[i];
        }
        int i = n - 1;
        while (i >= 0) {
            ans++;
            double max = time[i];
            while (i >= 0 && time[i] <= max) {
                i--;
            }
        }
        return ans;
    }
}