class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        
        int n = position.length;
        int res = 0;
        double[] time = new double[target + 1];
        for (int i = 0; i < n; i++) {
            time[position[i]] = (double)(target - position[i]) / speed[i];
        }
        double cur = 0;
        for (int i = target; i >= 0; i--) {
            if (time[i] > cur) {
                cur = time[i];
                res++;
            }
        }
        return res;
    }
}