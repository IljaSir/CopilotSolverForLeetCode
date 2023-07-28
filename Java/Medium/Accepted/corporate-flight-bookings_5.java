class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] ans = new int[n];
        for (int i = 0; i < bookings.length; i++) {
            int[] booking = bookings[i];
            ans[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                ans[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}