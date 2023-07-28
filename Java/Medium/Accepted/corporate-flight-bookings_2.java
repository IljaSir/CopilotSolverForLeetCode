class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        
        int[] seats = new int[n];
        for (int[] booking : bookings) {
            seats[booking[0] - 1] += booking[2];
            if (booking[1] < n) {
                seats[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < n; i++) {
            seats[i] += seats[i - 1];
        }
        return seats;
    }
}