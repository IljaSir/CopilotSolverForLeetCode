class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long min = 1;
        long max = (long)totalTrips * (long)time[0];
        while (min < max) {
            long mid = min + (max - min) / 2;
            long trips = 0;
            for (int i = 0; i < time.length; i++) {
                trips += mid / time[i];
            }
            if (trips >= totalTrips) {
                max = mid;
            }
            else {
                min = mid + 1;
            }
        }
        return min;
    }
}