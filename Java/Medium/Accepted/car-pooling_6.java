class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        
        int[] path = new int[1001];
        for (int[] trip : trips) {
            path[trip[1]] += trip[0];
            path[trip[2]] -= trip[0];
        }
        int cur = 0;
        for (int i = 0; i < 1001; i++) {
            cur += path[i];
            if (cur > capacity) return false;
        }
        return true;
    }
}