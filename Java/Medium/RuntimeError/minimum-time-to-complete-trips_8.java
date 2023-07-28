class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long min = 0;
        long max = 1000000000000000000L;
        while (min < max) {
            long mid = min + (max - min) / 2;
            long sum = 0;
            for (int i = 0; i < time.length; i++) {
                sum += mid / time[i];
            }
            if (sum >= totalTrips) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return min;
    }
}