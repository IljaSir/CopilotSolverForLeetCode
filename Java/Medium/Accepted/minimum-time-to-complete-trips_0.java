class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long l = 0, r = (long) 1e15;
        while (l < r) {
            long m = (l + r) / 2;
            long trips = 0;
            for (int t : time) {
                trips += m / t;
                if (trips >= totalTrips) {
                    break;
                }
            }
            if (trips >= totalTrips) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
}