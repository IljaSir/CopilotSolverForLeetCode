class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] time = new int[1001];
        for (int i = 0; i < trips.length; i++) {
            time[trips[i][1]] += trips[i][0];
            time[trips[i][2]] -= trips[i][0];
        }
        for (int i = 0; i < 1001; i++) {
            capacity -= time[i];
            if (capacity < 0) return false;
        }
        return true;
    }
}