class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long l = 0, r = (long)1e18;
        while (l < r) {
            long m = (l + r) / 2;
            long sum = 0;
            for (int i = 0; i < time.length; i++) {
                sum += m / time[i];
            }
            if (sum < totalTrips) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l;
    }
}