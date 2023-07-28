class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long low = 0;
        long high = 1000000000000000000L;
        while (low < high) {
            long mid = low + (high - low) / 2;
            long trips = 0;
            for (int t : time) {
                trips += mid / t;
            }
            if (trips < totalTrips) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}