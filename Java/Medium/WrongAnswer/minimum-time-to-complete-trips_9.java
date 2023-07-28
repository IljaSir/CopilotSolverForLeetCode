class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long l = 0, r = 1L * totalTrips * 1000000000;
        while (l < r) {
            long m = (l + r) >> 1;
            if (check(time, m, totalTrips)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    boolean check(int[] time, long t, int totalTrips) {
        long trips = 0;
        for (int i = 0; i < time.length; i++) {
            trips += t / time[i];
        }
        return trips >= totalTrips;
    }
}