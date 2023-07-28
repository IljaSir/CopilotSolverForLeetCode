class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long l = 1;
        long r = (long)totalTrips * 10000000;
        while (l < r) {
            long m = (l + r) / 2;
            long count = 0;
            for (int t: time) {
                count += m / t;
            }
            if (count < totalTrips) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}