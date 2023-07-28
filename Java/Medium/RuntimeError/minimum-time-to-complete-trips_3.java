class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long left = 0;
        long right = (long)1e17;
        long ans = 0;
        while (left <= right) {
            long mid = left + (right - left) / 2;
            long cnt = 0;
            for (int i = 0; i < time.length; i++) {
                cnt += mid / time[i];
            }
            if (cnt >= totalTrips) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}