class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] d = new int[1001];
        for (int[] trip : trips) {
            d[trip[1]] += trip[0];
            d[trip[2]] -= trip[0];
        }
        for (int i = 0; i < 1001; i++) {
            capacity -= d[i];
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }
}