class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        
        long left = 0;
        long right = (long) 1e18;
        while (left < right) {
            long mid = (left + right) >>> 1;
            if (count(time, mid) >= totalTrips) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long count(int[] time, long t) {
        long ans = 0;
        for (int i = 0; i < time.length; i++) {
            ans += (t / time[i]);
        }
        return ans;
    }
}