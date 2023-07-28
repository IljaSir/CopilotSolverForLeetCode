class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] delta = new int[1001];
        for (int[] trip : trips) {
            delta[trip[1]] += trip[0];
            delta[trip[2]] -= trip[0];
        }
        for (int i = 1; i <= 1000; i++) {
            delta[i] += delta[i - 1];
            if (delta[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}