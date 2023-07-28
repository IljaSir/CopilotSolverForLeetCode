class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] road = new int[1001];
        for (int[] trip : trips) {
            road[trip[1]] += trip[0];
            road[trip[2]] -= trip[0];
        }
        for (int i : road) {
            capacity -= i;
            if (capacity < 0) return false;
        }
        return true;
    }
}