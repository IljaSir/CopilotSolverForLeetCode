class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long l = 1;
        long r = (long)1e9;
        while (l < r) {
            long m = (l + r) / 2;
            long trips = 0;
            for (int t : time) {
                trips += m / t;
            }
            if (trips < totalTrips) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}