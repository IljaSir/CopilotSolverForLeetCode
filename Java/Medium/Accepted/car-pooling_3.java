class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] delta = new int[1001];
        for (int[] trip : trips) {
            delta[trip[1]] += trip[0];
            delta[trip[2]] -= trip[0];
        }
        for (int d : delta) {
            capacity -= d;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}